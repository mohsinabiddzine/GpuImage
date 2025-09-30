# Minimum version of CMake required
cmake_minimum_required(VERSION 3.22.1) # 3.4.1 works, but use newer for NDK r23+

# Project name
project(yuv_decoder)

# Create the shared library
add_library(
        yuv-decoder
        SHARED
        yuv-decoder.c
)

# Find required NDK libraries
find_library(log-lib log)
find_library(gles-lib GLESv2)
find_library(jnigraphics-lib jnigraphics)

# Link libraries
target_link_libraries(
        yuv-decoder
        ${log-lib}
        ${gles-lib}
        ${jnigraphics-lib}
        android
)

# ✅ Force 16KB page alignment for Google Play compliance
set(CMAKE_SHARED_LINKER_FLAGS "${CMAKE_SHARED_LINKER_FLAGS} -Wl,-z,max-page-size=16384")
