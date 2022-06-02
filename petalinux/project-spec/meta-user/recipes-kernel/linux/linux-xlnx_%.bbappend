FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append = " file://bsp.cfg \
            file://0001-media-i2c-ap1302-Update-the-min-values-for-ap1302-co.patch \
            file://0002-Adding-v4l-control-for-the-ap1302-AF-Flip-3d-path.patch \
            "
KERNEL_FEATURES_append = " bsp.cfg"
