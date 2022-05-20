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



*************************************
Create the Vitis Extensible Platform:
*************************************
To create the xbzu1_base Vitis platforms, run the following command:

```
make platform PFM=xbzu1_base
```


**************************
Create the Vitis Overlays:
**************************
To create the Vitis overlays, run the following commands:

```
make overlay OVERLAY=dpu_b512
```

```
make overlay OVERLAY=dpu_b128
```

```
make overlay OVERLAY=smart_model_select
```


*******************
Compile the models:
*******************
To compile the models for the B128 and B512 architectures, first copy the arch.json files:

```
cp overlays/examples/dpu_b512/binary_container_1/sd_card/arch.json modelzoo/arch-b512.json
cp overlays/examples/dpu_b128/binary_container_1/sd_card/arch.json modelzoo/arch-b128.json
```

Next, create a model-list directory that contains the models we want to compile:

As a first example, let's define the 16 models required by the smart model select example.
```
mkdir -p modelzoo/model-list
cp -r overlays/Vitis-AI/models/AI-Model-Zoo/model-list/cf_densebox_wider_360_640_1.11G_2.0 modelzoo/model-list/.
cp -r overlays/Vitis-AI/models/AI-Model-Zoo/model-list/cf_densebox_wider_320_320_0.49G_2.0 modelzoo/model-list/.
cp -r overlays/Vitis-AI/models/AI-Model-Zoo/model-list/cf_inceptionv1_imagenet_224_224_3.16G_2.0 modelzoo/model-list/.
cp -r overlays/Vitis-AI/models/AI-Model-Zoo/model-list/cf_mobilenetv2_imagenet_224_224_0.59G_2.0 modelzoo/model-list/.
cp -r overlays/Vitis-AI/models/AI-Model-Zoo/model-list/cf_refinedet_coco_360_480_0.96_5.08G_2.0 modelzoo/model-list/.
cp -r overlays/Vitis-AI/models/AI-Model-Zoo/model-list/cf_resnet18_imagenet_224_224_3.65G_2.0 modelzoo/model-list/.
cp -r overlays/Vitis-AI/models/AI-Model-Zoo/model-list/cf_resnet50_imagenet_224_224_7.7G_2.0 modelzoo/model-list/.
cp -r overlays/Vitis-AI/models/AI-Model-Zoo/model-list/cf_ssdadas_bdd_360_480_0.95_6.3G_2.0 modelzoo/model-list/.
cp -r overlays/Vitis-AI/models/AI-Model-Zoo/model-list/cf_ssdmobilenetv2_bdd_360_480_6.57G_2.0 modelzoo/model-list/.
cp -r overlays/Vitis-AI/models/AI-Model-Zoo/model-list/cf_ssdpedestrian_coco_360_640_0.97_5.9G_2.0 modelzoo/model-list/.
cp -r overlays/Vitis-AI/models/AI-Model-Zoo/model-list/cf_ssdtraffic_360_480_0.9_11.6G_2.0 modelzoo/model-list/.
cp -r overlays/Vitis-AI/models/AI-Model-Zoo/model-list/dk_tiny-yolov3_416_416_5.46G_2.0 modelzoo/model-list/.
cp -r overlays/Vitis-AI/models/AI-Model-Zoo/model-list/dk_yolov2_voc_448_448_0.77_7.82G_2.0 modelzoo/model-list/.
cp -r overlays/Vitis-AI/models/AI-Model-Zoo/model-list/dk_yolov2_voc_448_448_34G_2.0 modelzoo/model-list/.
cp -r overlays/Vitis-AI/models/AI-Model-Zoo/model-list/dk_yolov3_cityscapes_256_512_0.9_5.46G_2.0 modelzoo/model-list/.
cp -r overlays/Vitis-AI/models/AI-Model-Zoo/model-list/dk_yolov3_voc_416_416_65.42G_2.0 modelzoo/model-list/.

cp -r overlays/Vitis-AI/models/AI-Model-Zoo/model-list/cf_plate-detection_320_320_0.49G_2.0 modelzoo/model-list/.
cp -r overlays/Vitis-AI/models/AI-Model-Zoo/model-list/cf_plate-recognition_96_288_1.75G_2.0 modelzoo/model-list/.
```

As a second example, let's define all the models from the model-zoo.
```
cp -r overlays/Vitis-AI/models/AI-Model-Zoo/model-list modelzoo/model-list
```

Launch the Vitis-AI tools docker:
```
cp -r overlays/Vitis-AI/setup modelzoo/.

cd modelzoo
source ../overlays/Vitis-AI/docker_run.sh xilinx/vitis-ai:2.0.0.1103
```

To compile models for the B128 architecure:
```
source ./compile_modelzoo_b128.sh
```

To compile models for the B512 architecure:
```
source ./compile_modelzoo_b512.sh
```




*****************************
Create the Petalinux project:
*****************************
To create the petalinux project, first copy the following overlay files:

```
cp overlays/examples/dpu_b512/binary_container_1/sd_card/xbzu1_base_wrapper.bit petalinux/project-spec/meta-user/recipes-apps/avnet-zub1cg-dpu-b512_1.0/files/zub1cg-dpu-b512.bit
cp overlays/examples/dpu_b512/binary_container_1/sd_card/dpu.xclbin petalinux/project-spec/meta-user/recipes-apps/avnet-zub1cg-dpu-b512_1.0/files/zub1cg-dpu-b512.xclbin
```

```
cp overlays/examples/dpu_b128/binary_container_1/sd_card/xbzu1_base_wrapper.bit petalinux/project-spec/meta-user/recipes-apps/avnet-zub1cg-dpu-b128_1.0/files/zub1cg-dpu-b128.bit
cp overlays/examples/dpu_b128/binary_container_1/sd_card/dpu.xclbin petalinux/project-spec/meta-user/recipes-apps/avnet-zub1cg-dpu-b128_1.0/files/zub1cg-dpu-b128.xclbin
```

```
cp overlays/examples/smart_model_select/binary_container_1/sd_card/xbzu1_base_wrapper.bit petalinux/project-spec/meta-user/recipes-apps/avnet-zub1cg-vvas-sms_1.1/files/zub1cg-vvas-sms.bit
cp overlays/examples/smart_model_select/binary_container_1/sd_card/dpu.xclbin petalinux/project-spec/meta-user/recipes-apps/avnet-zub1cg-vvas-sms_1.1/files/zub1cg-vvas-sms.xclbin
```

Then, copy the compiled models:

```
cp modelzoo/models.b128/densebox_320_320/densebox_320_320.xmodel petalinux/project-spec/meta-user/recipes-apps/avnet-zub1cg-vvas-sms-models_1.1/files/models.b128/densebox_320_320/densebox_320_320.xmodel
cp modelzoo/models.b128/densebox_640_360/densebox_640_360.xmodel petalinux/project-spec/meta-user/recipes-apps/avnet-zub1cg-vvas-sms-models_1.1/files/models.b128/densebox_640_360/densebox_640_360.xmodel
cp modelzoo/models.b128/inception_v1/inception_v1.xmodel petalinux/project-spec/meta-user/recipes-apps/avnet-zub1cg-vvas-sms-models_1.1/files/models.b128/inception_v1/inception_v1.xmodel
cp modelzoo/models.b128/plate_detect/plate_detect.xmodel petalinux/project-spec/meta-user/recipes-apps/avnet-zub1cg-vvas-sms-models_1.1/files/models.b128/plate_detect/plate_detect.xmodel
cp modelzoo/models.b128/plate_num/plate_num.xmodel petalinux/project-spec/meta-user/recipes-apps/avnet-zub1cg-vvas-sms-models_1.1/files/models.b128/plate_num/plate_num.xmodel
cp modelzoo/models.b128/refinedet_pruned_0_96/refinedet_pruned_0_96.xmodel petalinux/project-spec/meta-user/recipes-apps/avnet-zub1cg-vvas-sms-models_1.1/files/models.b128/refinedet_pruned_0_96/refinedet_pruned_0_96.xmodel
cp modelzoo/models.b128/resnet18/resnet18.xmodel petalinux/project-spec/meta-user/recipes-apps/avnet-zub1cg-vvas-sms-models_1.1/files/models.b128/resnet18/resnet18.xmodel
cp modelzoo/models.b128/resnet50/resnet50.xmodel petalinux/project-spec/meta-user/recipes-apps/avnet-zub1cg-vvas-sms-models_1.1/files/models.b128/resnet50/resnet50.xmodel
cp modelzoo/models.b128/ssd_adas_pruned_0_95/ssd_adas_pruned_0_95.xmodel petalinux/project-spec/meta-user/recipes-apps/avnet-zub1cg-vvas-sms-models_1.1/files/models.b128/ssd_adas_pruned_0_95/ssd_adas_pruned_0_95.xmodel
cp modelzoo/models.b128/ssd_mobilenet_v2/ssd_mobilenet_v2.xmodel petalinux/project-spec/meta-user/recipes-apps/avnet-zub1cg-vvas-sms-models_1.1/files/models.b128/ssd_mobilenet_v2/ssd_mobilenet_v2.xmodel
cp modelzoo/models.b128/ssd_pedestrian_pruned_0_97/ssd_pedestrian_pruned_0_97.xmodel petalinux/project-spec/meta-user/recipes-apps/avnet-zub1cg-vvas-sms-models_1.1/files/models.b128/ssd_pedestrian_pruned_0_97/ssd_pedestrian_pruned_0_97.xmodel
cp modelzoo/models.b128/ssd_traffic_pruned_0_9/ssd_traffic_pruned_0_9.xmodel petalinux/project-spec/meta-user/recipes-apps/avnet-zub1cg-vvas-sms-models_1.1/files/models.b128/ssd_traffic_pruned_0_9/ssd_traffic_pruned_0_9.xmodel
cp modelzoo/models.b128/tiny_yolov3_vmss/tiny_yolov3_vmss.xmodel petalinux/project-spec/meta-user/recipes-apps/avnet-zub1cg-vvas-sms-models_1.1/files/models.b128/tiny_yolov3_vmss/tiny_yolov3_vmss.xmodel
cp modelzoo/models.b128/yolov2_voc_pruned_0_77/yolov2_voc_pruned_0_77.xmodel petalinux/project-spec/meta-user/recipes-apps/avnet-zub1cg-vvas-sms-models_1.1/files/models.b128/yolov2_voc_pruned_0_77/yolov2_voc_pruned_0_77.xmodel
cp modelzoo/models.b128/yolov3_voc/yolov3_voc.xmodel petalinux/project-spec/meta-user/recipes-apps/avnet-zub1cg-vvas-sms-models_1.1/files/models.b128/yolov3_voc/yolov3_voc.xmodel
```

Finally, configure and build the petalinux project

```
cd petalinux

mkdir .petalinux
touch .petalinux/metadata

petalinux-config --silentconfig --get-hw-description=../platforms/vivado/xbzu1_base/project/xbzu1_base.xsa

petalinux-build -c avnet-image-full
```


# License

(C) Copyright 2022 Avnet, Inc.\
SPDX-License-Identifier: Apache-2.0

