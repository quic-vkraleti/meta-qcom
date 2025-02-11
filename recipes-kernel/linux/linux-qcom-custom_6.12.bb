
require recipes-kernel/linux/linux-qcom.inc

# Additional configs for qcom custom variant kernel.
KERNEL_CONFIG_FRAGMENTS += "${S}/arch/arm64/configs/qcom_addons.config"

