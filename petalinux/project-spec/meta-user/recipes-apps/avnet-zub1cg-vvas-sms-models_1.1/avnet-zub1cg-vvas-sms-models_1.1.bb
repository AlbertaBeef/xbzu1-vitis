#
# This file is the zub1cg-vvas-sms-models recipe.
#

SUMMARY = "Pre-compiled models for zub1cg-vvas-sms application"
SECTION = "PETALINUX/apps"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = " \
	file://models.b128/densebox_320_320/densebox_320_320.prototxt \
	file://models.b128/densebox_320_320/densebox_320_320.xmodel \
	file://models.b128/densebox_640_360/densebox_640_360.prototxt \
	file://models.b128/densebox_640_360/densebox_640_360.xmodel \
	file://models.b128/inception_v1/inception_v1.prototxt \
	file://models.b128/inception_v1/inception_v1.xmodel \
	file://models.b128/refinedet_pruned_0_96/refinedet_pruned_0_96.prototxt \
	file://models.b128/refinedet_pruned_0_96/refinedet_pruned_0_96.xmodel \
	file://models.b128/resnet18/resnet18.prototxt \
	file://models.b128/resnet18/resnet18.xmodel \
	file://models.b128/resnet50/resnet50.prototxt \
	file://models.b128/resnet50/resnet50.xmodel \
	file://models.b128/ssd_adas_pruned_0_95/label.json \
	file://models.b128/ssd_adas_pruned_0_95/ssd_adas_pruned_0_95.prototxt \
	file://models.b128/ssd_adas_pruned_0_95/ssd_adas_pruned_0_95.xmodel \
	file://models.b128/ssd_mobilenet_v2/label.json \
	file://models.b128/ssd_mobilenet_v2/ssd_mobilenet_v2.prototxt \
	file://models.b128/ssd_mobilenet_v2/ssd_mobilenet_v2.xmodel \
	file://models.b128/ssd_pedestrian_pruned_0_97/label.json \
	file://models.b128/ssd_pedestrian_pruned_0_97/ssd_pedestrian_pruned_0_97.prototxt \
	file://models.b128/ssd_pedestrian_pruned_0_97/ssd_pedestrian_pruned_0_97.xmodel \
	file://models.b128/ssd_traffic_pruned_0_9/label.json \
	file://models.b128/ssd_traffic_pruned_0_9/ssd_traffic_pruned_0_9.prototxt \
	file://models.b128/ssd_traffic_pruned_0_9/ssd_traffic_pruned_0_9.xmodel \
	file://models.b128/plate_detect/plate_detect.prototxt \
	file://models.b128/plate_detect/plate_detect.xmodel \
	file://models.b128/plate_num/plate_num.prototxt \
	file://models.b128/plate_num/plate_num.xmodel \
	file://models.b128/yolov2_voc/label.json \
	file://models.b128/yolov2_voc/yolov2_voc.prototxt \
	file://models.b128/yolov2_voc/yolov2_voc.xmodel \
	file://models.b128/yolov2_voc_pruned_0_77/label.json \
	file://models.b128/yolov2_voc_pruned_0_77/yolov2_voc_pruned_0_77.prototxt \
	file://models.b128/yolov2_voc_pruned_0_77/yolov2_voc_pruned_0_77.xmodel \
	file://models.b128/yolov3_voc/label.json \
	file://models.b128/yolov3_voc/yolov3_voc.prototxt \
	file://models.b128/yolov3_voc/yolov3_voc.xmodel \
	"

SRC_URI_NOT = " \
	file://models.b128/densebox_320_320/meta.json \
	file://models.b128/densebox_640_360/meta.json \
	file://models.b128/inception_v1/meta.json \
	file://models.b128/refinedet_pruned_0_96/meta.json \
	file://models.b128/resnet18/meta.json \
	file://models.b128/resnet50/meta.json \
	file://models.b128/ssd_adas_pruned_0_95/meta.json \
	file://models.b128/ssd_mobilenet_v2/meta.json \
	file://models.b128/ssd_pedestrian_pruned_0_97/meta.json \
	file://models.b128/ssd_traffic_pruned_0_9/meta.json \
	file://models.b128/plate_detect/meta.json \
	file://models.b128/plate_num/meta.json \
	file://models.b128/yolov2_voc/meta.json \
	file://models.b128/yolov2_voc_pruned_0_77/meta.json \
	file://models.b128/yolov3_voc/meta.json \
	\
	file://models.b128/mobilenet_v2/meta.json \
	file://models.b128/mobilenet_v2/mobilenet_v2.prototxt \
	file://models.b128/mobilenet_v2/mobilenet_v2.xmodel \
	file://models.b128/yolov3_adas_pruned_0_9/label.json \
	file://models.b128/yolov3_adas_pruned_0_9/meta.json \
	file://models.b128/yolov3_adas_pruned_0_9/yolov3_adas_pruned_0_9.prototxt \
	file://models.b128/yolov3_adas_pruned_0_9/yolov3_adas_pruned_0_9.xmodel \
	file://models.b128/yolov3_voc_tf/label.json \
	file://models.b128/yolov3_voc_tf/meta.json \
	file://models.b128/yolov3_voc_tf/yolov3_voc_tf.prototxt \
	file://models.b128/yolov3_voc_tf/yolov3_voc_tf.xmodel \
	"
	
S = "${WORKDIR}"
PR = "1.pl2021_2"

do_install() {
	install -d ${D}/opt/avnet
	install -d ${D}/opt/avnet/zub1cg-vvas-sms
	install -d ${D}/opt/avnet/zub1cg-vvas-sms/models.b128

	install -d ${D}/opt/avnet/zub1cg-vvas-sms/models.b128/densebox_320_320
	install -m 0755 models.b128/densebox_320_320/* ${D}/opt/avnet/zub1cg-vvas-sms/models.b128/densebox_320_320

	install -d ${D}/opt/avnet/zub1cg-vvas-sms/models.b128/densebox_640_360
	install -m 0755 models.b128/densebox_640_360/* ${D}/opt/avnet/zub1cg-vvas-sms/models.b128/densebox_640_360

	install -d ${D}/opt/avnet/zub1cg-vvas-sms/models.b128/inception_v1
	install -m 0755 models.b128/inception_v1/* ${D}/opt/avnet/zub1cg-vvas-sms/models.b128/inception_v1

	#install -d ${D}/opt/avnet/zub1cg-vvas-sms/models.b128/mobilenet_v2
	#install -m 0755 models.b128/mobilenet_v2/* ${D}/opt/avnet/zub1cg-vvas-sms/models.b128/mobilenet_v2

	install -d ${D}/opt/avnet/zub1cg-vvas-sms/models.b128/refinedet_pruned_0_96
	install -m 0755 models.b128/refinedet_pruned_0_96/* ${D}/opt/avnet/zub1cg-vvas-sms/models.b128/refinedet_pruned_0_96

	install -d ${D}/opt/avnet/zub1cg-vvas-sms/models.b128/resnet18
	install -m 0755 models.b128/resnet18/* ${D}/opt/avnet/zub1cg-vvas-sms/models.b128/resnet18

	install -d ${D}/opt/avnet/zub1cg-vvas-sms/models.b128/resnet50
	install -m 0755 models.b128/resnet50/* ${D}/opt/avnet/zub1cg-vvas-sms/models.b128/resnet50

	install -d ${D}/opt/avnet/zub1cg-vvas-sms/models.b128/ssd_adas_pruned_0_95
	install -m 0755 models.b128/ssd_adas_pruned_0_95/* ${D}/opt/avnet/zub1cg-vvas-sms/models.b128/ssd_adas_pruned_0_95

	install -d ${D}/opt/avnet/zub1cg-vvas-sms/models.b128/ssd_mobilenet_v2
	install -m 0755 models.b128/ssd_mobilenet_v2/* ${D}/opt/avnet/zub1cg-vvas-sms/models.b128/ssd_mobilenet_v2

	install -d ${D}/opt/avnet/zub1cg-vvas-sms/models.b128/ssd_pedestrian_pruned_0_97
	install -m 0755 models.b128/ssd_pedestrian_pruned_0_97/* ${D}/opt/avnet/zub1cg-vvas-sms/models.b128/ssd_pedestrian_pruned_0_97

	install -d ${D}/opt/avnet/zub1cg-vvas-sms/models.b128/ssd_traffic_pruned_0_9
	install -m 0755 models.b128/ssd_traffic_pruned_0_9/* ${D}/opt/avnet/zub1cg-vvas-sms/models.b128/ssd_traffic_pruned_0_9

	install -d ${D}/opt/avnet/zub1cg-vvas-sms/models.b128/plate_detect
	install -m 0755 models.b128/plate_detect/* ${D}/opt/avnet/zub1cg-vvas-sms/models.b128/plate_detect

	install -d ${D}/opt/avnet/zub1cg-vvas-sms/models.b128/plate_num
	install -m 0755 models.b128/plate_num/* ${D}/opt/avnet/zub1cg-vvas-sms/models.b128/plate_num

	install -d ${D}/opt/avnet/zub1cg-vvas-sms/models.b128/yolov2_voc
	install -m 0755 models.b128/yolov2_voc/* ${D}/opt/avnet/zub1cg-vvas-sms/models.b128/yolov2_voc

	install -d ${D}/opt/avnet/zub1cg-vvas-sms/models.b128/yolov2_voc_pruned_0_77
	install -m 0755 models.b128/yolov2_voc_pruned_0_77/* ${D}/opt/avnet/zub1cg-vvas-sms/models.b128/yolov2_voc_pruned_0_77

	#install -d ${D}/opt/avnet/zub1cg-vvas-sms/models.b128/yolov3_adas_pruned_0_9
	#install -m 0755 models.b128/yolov3_adas_pruned_0_9/* ${D}/opt/avnet/zub1cg-vvas-sms/models.b128/yolov3_adas_pruned_0_9

	install -d ${D}/opt/avnet/zub1cg-vvas-sms/models.b128/yolov3_voc
	install -m 0755 models.b128/yolov3_voc/* ${D}/opt/avnet/zub1cg-vvas-sms/models.b128/yolov3_voc

	#install -d ${D}/opt/avnet/zub1cg-vvas-sms/models.b128/yolov3_voc_tf
	#install -m 0755 models.b128/yolov3_voc_tf/* ${D}/opt/avnet/zub1cg-vvas-sms/models.b128/yolov3_voc_tf
}


#FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/models.b128/densebox_320_320/meta.json"
FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/models.b128/densebox_320_320/densebox_320_320.prototxt"
FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/models.b128/densebox_320_320/densebox_320_320.xmodel"

#FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/models.b128/densebox_640_360/meta.json"
FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/models.b128/densebox_640_360/densebox_640_360.prototxt"
FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/models.b128/densebox_640_360/densebox_640_360.xmodel"

#FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/models.b128/inception_v1/meta.json"
FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/models.b128/inception_v1/inception_v1.prototxt"
FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/models.b128/inception_v1/inception_v1.xmodel"

#FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/models.b128/mobilenet_v2/meta.json"
#FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/models.b128/mobilenet_v2/mobilenet_v2.prototxt"
#FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/models.b128/mobilenet_v2/mobilenet_v2.xmodel"

#FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/models.b128/refinedet_pruned_0_96/meta.json"
FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/models.b128/refinedet_pruned_0_96/refinedet_pruned_0_96.prototxt"
FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/models.b128/refinedet_pruned_0_96/refinedet_pruned_0_96.xmodel"

#FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/models.b128/resnet18/meta.json"
FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/models.b128/resnet18/resnet18.prototxt"
FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/models.b128/resnet18/resnet18.xmodel"

#FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/models.b128/resnet50/meta.json"
FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/models.b128/resnet50/resnet50.prototxt"
FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/models.b128/resnet50/resnet50.xmodel"

FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/models.b128/ssd_adas_pruned_0_95/label.json"
#FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/models.b128/ssd_adas_pruned_0_95/meta.json"
FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/models.b128/ssd_adas_pruned_0_95/ssd_adas_pruned_0_95.prototxt"
FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/models.b128/ssd_adas_pruned_0_95/ssd_adas_pruned_0_95.xmodel"

FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/models.b128/ssd_mobilenet_v2/label.json"
#FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/models.b128/ssd_mobilenet_v2/meta.json"
FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/models.b128/ssd_mobilenet_v2/ssd_mobilenet_v2.prototxt"
FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/models.b128/ssd_mobilenet_v2/ssd_mobilenet_v2.xmodel"

FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/models.b128/ssd_pedestrian_pruned_0_97/label.json"
#FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/models.b128/ssd_pedestrian_pruned_0_97/meta.json"
FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/models.b128/ssd_pedestrian_pruned_0_97/ssd_pedestrian_pruned_0_97.prototxt"
FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/models.b128/ssd_pedestrian_pruned_0_97/ssd_pedestrian_pruned_0_97.xmodel"

FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/models.b128/ssd_traffic_pruned_0_9/label.json"
#FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/models.b128/ssd_traffic_pruned_0_9/meta.json"
FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/models.b128/ssd_traffic_pruned_0_9/ssd_traffic_pruned_0_9.prototxt"
FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/models.b128/ssd_traffic_pruned_0_9/ssd_traffic_pruned_0_9.xmodel"

#FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/models.b128/plate_detect/meta.json"
FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/models.b128/plate_detect/plate_detect.prototxt"
FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/models.b128/plate_detect/plate_detect.xmodel"

#FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/models.b128/plate_num/meta.json"
FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/models.b128/plate_num/plate_num.prototxt"
FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/models.b128/plate_num/plate_num.xmodel"

FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/models.b128/yolov2_voc/label.json"
#FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/models.b128/yolov2_voc/meta.json"
FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/models.b128/yolov2_voc/yolov2_voc.prototxt"
FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/models.b128/yolov2_voc/yolov2_voc.xmodel"

FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/models.b128/yolov2_voc_pruned_0_77/label.json"
#FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/models.b128/yolov2_voc_pruned_0_77/meta.json"
FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/models.b128/yolov2_voc_pruned_0_77/yolov2_voc_pruned_0_77.prototxt"
FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/models.b128/yolov2_voc_pruned_0_77/yolov2_voc_pruned_0_77.xmodel"

#FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/models.b128/yolov3_adas_pruned_0_9/label.json"
#FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/models.b128/yolov3_adas_pruned_0_9/meta.json"
#FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/models.b128/yolov3_adas_pruned_0_9/yolov3_adas_pruned_0_9.prototxt"
#FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/models.b128/yolov3_adas_pruned_0_9/yolov3_adas_pruned_0_9.xmodel"

FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/models.b128/yolov3_voc/label.json"
#FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/models.b128/yolov3_voc/meta.json"
FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/models.b128/yolov3_voc/yolov3_voc.prototxt"
FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/models.b128/yolov3_voc/yolov3_voc.xmodel"

#FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/models.b128/yolov3_voc_tf/label.json"
#FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/models.b128/yolov3_voc_tf/meta.json"
#FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/models.b128/yolov3_voc_tf/yolov3_voc_tf.prototxt"
#FILES_${PN} += "/opt/avnet/zub1cg-vvas-sms/models.b128/yolov3_voc_tf/yolov3_voc_tf.xmodel"


