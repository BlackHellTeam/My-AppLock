LOCAL_PATH:= $(call my-dir)
include $(CLEAR_VARS)
LOCAL_MODULE_TAGS := optional

LOCAL_SRC_FILES := $(call all-java-files-under, src)

LOCAL_STATIC_JAVA_LIBRARIES := android-support-v4 \
                                      android-support-v13 \
                                      lewa-support-v7-appcompat \
                                      com.lewa.themes


LOCAL_AAPT_FLAGS := \
        --auto-add-overlay \
        --extra-packages lewa.support.v7.appcompat


LOCAL_RESOURCE_DIR := $(LOCAL_PATH)/res
LOCAL_RESOURCE_DIR += vendor/lewa/apps/LewaSupportLib/actionbar_4.4/res

LOCAL_PACKAGE_NAME := LewaAppLock
LOCAL_CERTIFICATE := platform

include $(BUILD_PACKAGE)

include $(call all-makefiles-under,$(LOCAL_PATH))
