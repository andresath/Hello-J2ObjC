SHELL=/bin/bash
.SUFFIXES: .java .m
.PHONY: translate_dependencies

BUILD_DIR = build
SRC_DIR = src
DEPS_DIR = $(realpath ../../../deps)
LIBS_DIR = $(realpath ../../../deps/libs)
APP_DIR = $(SRC_DIR)/main/java
TEST_DIR = $(SRC_DIR)/test/java
PREFIX_PROPERTIES = ./prefixes.properties

# Change to where distribution was unzipped.
J2OBJC_PATH = $(J2OBJC_HOME)
J2OBJC = $(J2OBJC_PATH)/j2objc
J2OBJCC = $(J2OBJC_PATH)/j2objcc

APP_JAVA_SRCS = $(shell find $(APP_DIR) -type f -name '*.java')
TEST_JAVA_SRCS = $(shell find $(TEST_DIR) -type f -name '*.java')
APP_OBJECTS = $(patsubst $(APP_DIR)/%.java, $(BUILD_DIR)/%.o, $(APP_JAVA_SRCS))
APP_OBJC_SRCS = $(patsubst %.o,%.m,$(APP_OBJECTS))
APP_STATIC_LIB_VERSION = 0.0.1
APP_STATIC_LIB_NAME = core-petstore-data-$(APP_STATIC_LIB_VERSION)
APP_STATIC_LIB = $(BUILD_DIR)/libs/totspCore.a


DEP_LOCAL_LIBS_ROOT=$(LIBS_DIR)/local_src
DEP_LOCAL_LIBS = $(shell find $(DEP_LOCAL_LIBS_ROOT) -name '*-sources')
DEP_LOCAL_LIBS_CLASSPATH = $(shell find $(DEP_LOCAL_LIBS_ROOT) -name '*-sources' | paste -s -d":" -)
TRANSLATED_LIBS_ROOT=$(DEPS_DIR)/$(BUILD_DIR)/libs/translated
TRANSLATED_LIB_OBJECTS = $(patsubst $(APP_DIR)/%.java, $(BUILD_DIR)/%.o, $(APP_JAVA_SRCS))
TRANSLATED_LIB_SRCS = $(patsubst %.o,%.m,$(APP_OBJECTS))
TRANSLATED_LIBS = $(shell find $(TRANSLATED_LIBS_ROOT) -name '*-sources')
TRANSLATED_LIBS_INCLUDE_ARGS = $(addprefix -I,$(shell find $(TRANSLATED_LIBS_ROOT) -name '*-sources'))
TRANSLATED_LIBS_LINK_ARGS = $(addprefix -l, $(patsubst lib%,%,$(basename $(notdir $(shell find $(TRANSLATED_LIBS_ROOT) -name '*.a')))))
TRANSLATED_LIBS_LIBRARY_SEARCH_PATHS = $(addprefix -L,$(shell find $(TRANSLATED_LIBS_ROOT) -name '*-sources'))


DEP_JRE_EMUL=$(J2OBJC_PATH)/lib/jre_emul-src.jar
DEP_GUAVA=$(J2OBJC_PATH)/lib/guava-19.0.jar
DEP_JSR=$(J2OBJC_PATH)/lib/jsr305-3.0.0.jar
DEP_JAVAX=$(J2OBJC_PATH)/lib/javax.inject-1.jar
DEP_ANNOTATIONS=$(J2OBJC_PATH)/lib/j2objc_annotations.jar
DEP_JUNIT=$(J2OBJC_PATH)/lib/j2objc_junit.jar
DEP_MOCKITO=$(J2OBJC_PATH)/lib/mockito-core-1.9.5.jar

DEP_J2OBJC_DIST_LIBS_CLASSPATH=$(DEP_JRE_EMUL):$(DEP_GUAVA):$(DEP_JSR):$(DEP_JAVAX):$(DEP_ANNOTATIONS)
DEP_J2OBJC_DIST_TEST_CLASSPATH=$(DEP_J2OBJC_DIST_LIBS_CLASSPATH):$(DEP_JUNIT):$(DEP_MOCKITO)

# If `make debug_trace=1`
# $(debug_enter)
debug_enter = $(if $(debug_trace),\
 $(warning Entering $0($(echo-args))))

# $(debug_leave)
debug_leave = $(if $(debug_trace),$(warning Leaving $0))

# $(call assert,condition,message)
define assert
 $(if $1,,$(error Assertion failed: $2))
endef

# $(call assert_file_exists,wildcard_pattern)
define assert_file_exists
 $(call assert,$(wildcard $1),$1 does not exist)
endef

# $(call assert_not_null,somevar)
define assert_not_null
 $(call assert,$($1),The variable "$1" is null)
endef

default: translate translate_tests
	@:

translate: $(APP_JAVA_SRCS)
	$(eval translated_dir=$(BUILD_DIR)/translated/main)
	$(shell mkdir -p $(translated_dir))
	# Translating Java to Objective C, with local dependency translation...
	$(J2OBJC) -use-arc --swift-friendly --nullability --doc-comments \
	--prefixes $(PREFIX_PROPERTIES) \
	-d $(translated_dir) \
	-sourcepath $(APP_DIR):$(DEP_LOCAL_LIBS_CLASSPATH) -classpath $(DEP_LOCAL_LIBS_CLASSPATH):$(DEP_J2OBJC_DIST_LIBS_CLASSPATH):. \
	$(APP_JAVA_SRCS) \
	>> $(translated_dir)/j2objc.log 2>> $(translated_dir)/j2objc_err.log \
	&& echo "Success" || echo "Error"

	$(eval translated_source_files=$(shell find $(translated_dir) -type f -name '*.m' | sed -E "s/[$$]+/\\$$\$$/g" | sed "s/.*/'&'/"))
	$(eval translated_source_files_no_root=$(patsubst $(translated_dir)/%, ./%, $(translated_source_files)))

    # Static Libraries MUST be prefixed with "lib" as in libgson-1.1.1.a
    # and later linked with -lgson-1.1.1.a
    # unknown of why this works for j2ObjC libraries without prefixing
    # see `man ld` => -lx for more info
	$(info $(translated_source_files_no_root))
	cd $(translated_dir) && $(J2OBJCC) -fobjc-arc \
      -o $(translated_dir)/lib$(APP_STATIC_LIB_NAME).a \
      $(TRANSLATED_LIBS_LIBRARY_SEARCH_PATHS) \
      -I./ $(TRANSLATED_LIBS_INCLUDE_ARGS) \
      -ljre_emul -lguava -ljavax_inject -ljsr305 \
      $(TRANSLATED_LIBS_LINK_ARGS) \
      $(shell cd $(translated_dir) && find * -type f -name '*.m') -v

translate_tests: $(TEST_JAVA_SRCS)
	$(eval translated_dir=$(BUILD_DIR)/translated/test)
	$(shell mkdir -p $(translated_dir))
	# Translating Java to Objective C, with local dependency translation...
	$(J2OBJC) -use-arc --swift-friendly --nullability --doc-comments \
	-d $(translated_dir) \
	--prefixes $(PREFIX_PROPERTIES) \
	-sourcepath $(APP_DIR):$(DEP_LOCAL_LIBS_CLASSPATH) -classpath $(DEP_LOCAL_LIBS_CLASSPATH):$(DEP_J2OBJC_DIST_TEST_CLASSPATH):. \
	$(TEST_JAVA_SRCS) \
	>> $(translated_dir)/j2objc.log 2>> $(translated_dir)/j2objc_err.log \
	&& echo "Success" || echo "Error"

clean:
	@rm -rf $(BUILD_DIR)

vanilla_compile:
	# Validating vanilla JVM compile...
	javac -implicit:none -d $(BUILD_DIR) \
	-Xprefer:newer \
	-sourcepath $(APP_DIR):$(DEP_LOCAL_LIBS_CLASSPATH)
	-classpath $(DEP_LOCAL_LIBS_CLASSPATH):$(DEP_J2OBJC_DIST_LIBS_CLASSPATH):. \
	$(APP_JAVA_SRCS)

compile_objects:
	echo "Compiling Object Files..."
	$(BUILD_DIR)/%.m: $(BUILD_DIR)/%.o
		$(J2OBJCC) -ObjC -I$(BUILD_DIR) -ljre_emul -lguava -ljavax_inject -ljsr305 -o $@

package:
	libtool -o $(APP_STATIC_LIB) $(APP_OBJECTS) $(APP_STATIC_LIB)

$(BUILD_DIR):
	@mkdir -p $(BUILD_DIR)

$(TRANSLATED_LIBS_ROOT):
	@mkdir -p $(TRANSLATED_LIBS_ROOT)