DESCRIPTION = "Tiny ramdisk image with SC8180X devices firmware files"

PACKAGE_INSTALL += " \
    packagegroup-firmware-sc8180x \
"

BAD_RECOMMENDATIONS = " \
    linux-firmware-qca \
    linux-firmware-ath10k \
    linux-firmware-qcom-sc8180x-compute \
    linux-firmware-qcom-sc8180x-ipa \
    linux-firmware-qcom-sc8180x-modem \
    linux-firmware-qcom-sc8180x-sensors \
    linux-firmware-qcom-sc8180x-venus \
"

require initramfs-firmware-image.inc
