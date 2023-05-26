DESCRIPTION = "TSS A1"
SECTION = "examples"
LICENSE = "CLOSED"

SRC_URI = "file://file-A1.txt"

do_install() {
    mkdir -p ${D}/usr/share
    install -m 0644 ${WORKDIR}/file-A1.txt ${D}/usr/share
}

FILES:${PN} += "/usr/share"
