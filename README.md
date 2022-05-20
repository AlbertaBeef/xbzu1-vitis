# xbzu1-vitis
Avnet XBoard-ZU1 Vitis platforms and overlays 

# Instructions

This repo contains submodules. To clone this repo, run:
```
git clone --recursive https://github.com/AlbertaBeef/xbzu1-vitis.git
```

# Tools Version

The supported Xilinx tools release is 2021.2.

Install y2k22_patch for Vivado HLS and Vitis HLS tools to avoid 'Y2K22 Overflow Issue'.
Refer to the following Answer Record for obtaining the patch.

https://support.xilinx.com/s/article/76960?language=en_US

# Contents

This reference design contains the following:

1. platforms

   This folder contains the XBoard-ZU1 Vitis platforms. Follow the REAMDE inside this
   folder for build instructions.

2. overlays

   This folder contains the Vitis overlay projects which include the DPU
   inference engine RTL kernel and HLS-based computer vision kernels based on
   the Vitis Vision libraries. Follow the README inside this folder for detailed
   build instructions.

3. Makefile

   Top-level Makefile for building the Vitis platforms and overlay projects.
   Type 'make' or 'make help' to print the help text explaining the different
   make targets.

4. README

   This file.


# Linked repositories

This repository makes use of the following repositories (linked as git submodules):

1. Vitis Libraries

overlays/Vitis_Libraries : https://github.com/Xilinx/Vitis_Libraries/tree/4bd100518d93a8842d1678046ad7457f94eb355c

2. Vitis-AI

overlays/Vitis-AI : https://github.com/Xilinx/Vitis-AI/tree/6b96cc3b5a369bce67cf782649c6081ece203444

3. Avnet board files (BDF)

platforms/bdf : https://github.com/Avnet/bdf/tree/d67dcab8014e11a24503cc4b6d6cba0440631217

4. Avnet meta yocto

petalinux/project-spec/meta-avnet : https://github.com/Avnet/avnet-meta/tree/90a3aaa4fedd9c678667a2441f3d3aa99ffe426a


# Documentation


Create the Vitis Extensible Platform:
*************************************
To create the xbzu1_base Vitis platforms, run the following command:

'''
make platform PFM=xbzu1_base
'''

Create the Vitis Overlays:
**************************
To create the Vitis overlays, run the following commands:

'''
make overlay OVERLAY=dpu_b512
'''

'''
make overlay OVERLAY=dpu_b128
'''

'''
make overlay OVERLAY=smart_model_select
'''

Create the Petalinux project:
*****************************
To create the petalinux project, first copy the following overlay files:

'''
cp overlays/examples/dpu_b512/binary_container_1/sd_card/xbzu1_base_wrapper.bit petalinux/project-spec/meta-user/recipes-apps/avnet-zub1cg-dpu-b512_1.0/files/zub1cg-dpu-b512.bit
cp overlays/examples/dpu_b512/binary_container_1/sd_card/dpu.xclbin petalinux/project-spec/meta-user/recipes-apps/avnet-zub1cg-dpu-b512_1.0/files/zub1cg-dpu-b512.xclbin
'''

'''
cp overlays/examples/dpu_b128/binary_container_1/sd_card/xbzu1_base_wrapper.bit petalinux/project-spec/meta-user/recipes-apps/avnet-zub1cg-dpu-b128_1.0/files/zub1cg-dpu-b128.bit
cp overlays/examples/dpu_b128/binary_container_1/sd_card/dpu.xclbin petalinux/project-spec/meta-user/recipes-apps/avnet-zub1cg-dpu-b128_1.0/files/zub1cg-dpu-b128.xclbin
'''

'''
cp overlays/examples/smart_model_select/binary_container_1/sd_card/xbzu1_base_wrapper.bit petalinux/project-spec/meta-user/recipes-apps/avnet-zub1cg-vvas-sms_1.1/files/zub1cg-vvas-sms.bit
cp overlays/examples/smart_model_select/binary_container_1/sd_card/dpu.xclbin petalinux/project-spec/meta-user/recipes-apps/avnet-zub1cg-vvas-sms_1.1/files/zub1cg-vvas-sms.xclbin
'''

Then, copy the compiled models:

'''
... TBD ...
'''

Finally, configure and build the petalinux project

'''
cd petalinux

mkdir .petalinux
touch .petalinux/metadata

petalinux-config --silentconfig --get-hw-description=../platforms/vivado/xbzu1_base/project/xbzu1_base.xsa

petalinux-build -c avnet-image-full
'''


# License

(C) Copyright 2022 Avnet, Inc.\
SPDX-License-Identifier: Apache-2.0

