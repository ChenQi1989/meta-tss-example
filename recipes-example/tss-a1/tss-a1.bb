DESCRIPTION = "TSS A1"
SECTION = "examples"
LICENSE = "CLOSED"

SRC_URI = "file://file-A1.txt"

INHIBIT_DEFAULT_DEPS = "1"

do_install() {
    mkdir -p ${D}/usr/share
    install -m 0644 ${WORKDIR}/file-A1.txt ${D}/usr/share
}

FILES:${PN} += "/usr/share"

inherit nopackages
