inherit module

DESCRIPTION = "QCOM Video device-tree overlays"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/${LICENSE};md5=550794465ba0ec5312d6919e203a55f9"

SRCREV  = "52d2fbdaf53ebc13d559f85bcb15df4bdc7a06c5"
SRC_URI = "git://git.codelinaro.org/clo/le/platform/vendor/opensource/video-devicetree.git;protocol=https;branch=video.qclinux.0.0"

S = "${WORKDIR}/git"

DTBO_TARGET = ""
DTBO_TARGET:qcm6490 = "qcm6490-video"
DTBO_TARGET:qcs9100 = "sa8775p-video"
DTBO_TARGET:qcs8300 = "qcs8300-video"

EXTRA_OEMAKE += "DTC='${KBUILD_OUTPUT}/scripts/dtc/dtc' "
EXTRA_OEMAKE += "KERNEL_INCLUDE='${STAGING_KERNEL_DIR}/include' "

do_compile() {
    oe_runmake ${EXTRA_OEMAKE} ${DTBO_TARGET}
}

do_install() {
    install -d ${D}/devicetree
    install -m 0644 ${S}/*.dtbo -D ${D}/devicetree
}

PACKAGES = "${PN}"
FILES:${PN} = "/devicetree/*"

inherit deploy
do_deploy() {
    install -d ${DEPLOYDIR}/devicetree
    install -m 0644 ${D}/devicetree/*.dtbo -D ${DEPLOYDIR}/devicetree
}
addtask deploy before do_build after do_install
