#
# This file is the zub1cg-vvas-sms-app recipe.
#

SUMMARY = "Simple zub1cg-vvas-sms-app application"
SECTION = "PETALINUX/apps"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = " \
	file://smart_model_select.c \
	file://setup.sh \
	file://jsons/kernel_bbox.json \
	file://jsons/kernel_dpu.json \
	file://jsons/kernel_preprocessor.json \
	file://templates/welcome_1080.jpg \
	file://templates/welcome.cfg \
	file://templates/file_fake_template.cfg \
	file://templates/file_fake_template_perf.cfg \
	file://templates/file_file_template.cfg \
	file://templates/file_kms_template.cfg \
	file://templates/rtsp_fake_template.cfg \
	file://templates/rtsp_file_template.cfg \
	file://templates/rtsp_kms_template.cfg \
	file://templates/usbcam_fake_template.cfg \
	file://templates/usbcam_file_template.cfg \
	file://templates/usbcam_kms_template.cfg \
	file://templates/mipi_fake_template.cfg \
	file://templates/mipi_file_template.cfg \
	file://templates/mipi_kms_template.cfg \
	file://videos/CLASSIFICATION.mp4 \
	file://videos/FACEDETECT.mp4 \
	file://videos/REFINEDET.mp4 \
	file://videos/SSD.mp4 \
	file://videos/YOLOV2.mp4 \
	file://videos/YOLOV3.mp4 \
	"

S = "${WORKDIR}"
PR = "1.pl2021_2"

DEPENDS = "glib-2.0 glib-2.0-native xrt libcap libxml2 bison-native flex-native jansson vvas-utils vvas-gst opencv vitis-ai-library vart"

do_compile() {
	${CC} ${CFLAGS} ${LDFLAGS} -o smart_model_select smart_model_select.c -lpthread
}

do_install() {
	install -d ${D}/opt/avnet
	install -d ${D}/opt/avnet/zub1cg-vvas-sms/app
	install -m 0755 smart_model_select ${D}/opt/avnet/zub1cg-vvas-sms/app
	install -m 0755 setup.sh           ${D}/opt/avnet/zub1cg-vvas-sms/app

	install -d ${D}/opt/avnet/zub1cg-vvas-sms/app/jsons
	install -m 0755 jsons/kernel_bbox.json         ${D}/opt/avnet/zub1cg-vvas-sms/app/jsons
	install -m 0755 jsons/kernel_dpu.json          ${D}/opt/avnet/zub1cg-vvas-sms/app/jsons
	install -m 0755 jsons/kernel_preprocessor.json ${D}/opt/avnet/zub1cg-vvas-sms/app/jsons

	install -d ${D}/opt/avnet/zub1cg-vvas-sms/app/templates
	install -m 0755 templates/welcome_1080.jpg       ${D}/opt/avnet/zub1cg-vvas-sms/app/templates
	install -m 0755 templates/welcome.cfg            ${D}/opt/avnet/zub1cg-vvas-sms/app/templates
	install -m 0755 templates/*_template_perf.cfg    ${D}/opt/avnet/zub1cg-vvas-sms/app/templates
	install -m 0755 templates/file_*_template.cfg    ${D}/opt/avnet/zub1cg-vvas-sms/app/templates
	install -m 0755 templates/rtsp_*_template.cfg    ${D}/opt/avnet/zub1cg-vvas-sms/app/templates
	install -m 0755 templates/usbcam_*_template.cfg  ${D}/opt/avnet/zub1cg-vvas-sms/app/templates
	install -m 0755 templates/mipi_*_template.cfg    ${D}/opt/avnet/zub1cg-vvas-sms/app/templates

	install -d ${D}/opt/avnet/zub1cg-vvas-sms/app/videos
	install -m 0755 videos/CLASSIFICATION.mp4 ${D}/opt/avnet/zub1cg-vvas-sms/app/videos
	install -m 0755 videos/FACEDETECT.mp4     ${D}/opt/avnet/zub1cg-vvas-sms/app/videos
	install -m 0755 videos/REFINEDET.mp4      ${D}/opt/avnet/zub1cg-vvas-sms/app/videos
	install -m 0755 videos/SSD.mp4            ${D}/opt/avnet/zub1cg-vvas-sms/app/videos
	install -m 0755 videos/YOLOV2.mp4         ${D}/opt/avnet/zub1cg-vvas-sms/app/videos
	install -m 0755 videos/YOLOV3.mp4         ${D}/opt/avnet/zub1cg-vvas-sms/app/videos
}

FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/app/smart_model_select"
FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/app/setup.sh"

FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/app/jsons/kernel_bbox.json"
FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/app/jsons/kernel_dpu.json"
FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/app/jsons/kernel_preprocessor.json"

FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/app/templates/welcome_1080.jpg"
FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/app/templates/welcome.cfg"
FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/app/templates/file_fake_template.cfg"
FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/app/templates/file_fake_template_perf.cfg"
FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/app/templates/file_file_template.cfg"
FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/app/templates/file_kms_template.cfg"
FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/app/templates/rtsp_fake_template.cfg"
FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/app/templates/rtsp_file_template.cfg"
FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/app/templates/rtsp_kms_template.cfg"
FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/app/templates/usbcam_fake_template.cfg"
FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/app/templates/usbcam_file_template.cfg"
FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/app/templates/usbcam_kms_template.cfg"
FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/app/templates/mipi_fake_template.cfg"
FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/app/templates/mipi_file_template.cfg"
FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/app/templates/mipi_kms_template.cfg"

FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/app/videos/CLASSIFICATION.mp4"
FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/app/videos/FACEDETECT.mp4"
FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/app/videos/REFINEDET.mp4"
FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/app/videos/SSD.mp4"
FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/app/videos/YOLOV2.mp4"
FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/app/videos/YOLOV3.mp4"

