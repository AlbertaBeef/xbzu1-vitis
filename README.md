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

https://github.com/Xilinx/Vitis_Libraries/tree/4bd100518d93a8842d1678046ad7457f94eb355c

2. Vitis-AI

https://github.com/Xilinx/Vitis-AI/tree/6b96cc3b5a369bce67cf782649c6081ece203444

3. Avnet board files (BDF)

https://github.com/Avnet/bdf/tree/94dbc854faae34312c1ddfe15d335ed69256a660


# Documentation

Create a Vitis Extensible Platform:
***********************************
To create one of the Vitis platforms, run the following command:

> make platform PFM=<platform_name>

Create a Vitis Overlay:
***********************
To create one of the Vitis overlays, run the following command:

> make overlay OVERLAY=<overlay_name>



# License

(C) Copyright 2022 Avnet, Inc.\
SPDX-License-Identifier: Apache-2.0

