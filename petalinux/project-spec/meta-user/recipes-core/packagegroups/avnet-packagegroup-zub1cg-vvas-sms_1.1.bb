DESCRIPTION = "ZUBoard VVAS smart_model_select related packages"

inherit packagegroup

ZUB1CG_VVAS_SMS_PACKAGES = " \
   avnet-zub1cg-vvas-sms \
   avnet-zub1cg-vvas-sms-models \
   avnet-zub1cg-vvas-sms-app \
   git \
   dnf \
   libdrm libdrm-tests libdrm-kms \
   xrt xrt-dev \
   zocl \
   opencl-headers \
   packagegroup-petalinux-vitisai \
   packagegroup-petalinux-vitisai-dev \
   packagegroup-petalinux-gstreamer \
   packagegroup-petalinux-opencv \
   packagegroup-petalinux-v4lutils \
   packagegroup-petalinux-x11 \
   htop \
   jansson \
   target-factory \
   unilog vart vitis-ai-library xir \
   vvas-accel-libs vvas-gst vvas-utils \
   xmutil platformstats dfx-mgr ddr-qos axi-qos \
   "


RDEPENDS_${PN} = "${ZUB1CG_VVAS_SMS_PACKAGES}"

PR = "1.pl2021_2"
COMPATIBLE_MACHINE = "^$"
COMPATIBLE_MACHINE_zub1cg-sbc = "${MACHINE}"

PACKAGE_ARCH = "${BOARDVARIANT_ARCH}"

