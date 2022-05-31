#
# This file is the zub1cg-dpu-b512-boot recipe.
#

SUMMARY = "Default boot overlay configuration"
SECTION = "PETALINUX/apps"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = " \
	file://default_firmware \
	"

S = "${WORKDIR}"
PR = "1.pl2021_2"

do_install() {
	install -d ${D}/etc/dfx-mgrd
	install -m 0755 default_firmware   ${D}/etc/dfx-mgrd/default_firmware

	install -d ${D}/usr/share
	install -d ${D}/usr/share/vitis_ai_library
	#install -d ${D}/usr/share/vitis_ai_library/models.b512
	#ln -srvf ${D}/usr/share/vitis_ai_library/models.b512 ${D}/usr/share/vitis_ai_library/models
	ln -sf models.b512 ${D}/usr/share/vitis_ai_library/models
}

FILES_${PN} += "/etc/dfx-mgrd/default_firmware"

#FILES_${PN} += "/usr/share/vitis_ai_library/models.b512"
FILES_${PN} += "/usr/share/vitis_ai_library/models"

