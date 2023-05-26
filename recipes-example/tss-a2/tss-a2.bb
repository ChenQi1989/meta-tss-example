DESCRIPTION = "TSS A2"
SECTION = "examples"
LICENSE = "CLOSED"

SRC_URI = "file://file-A2.txt"

do_install() {
    mkdir -p ${D}/usr/share
    install -m 0644 ${WORKDIR}/file-A2.txt ${D}/usr/share
}

FILES:${PN} += "/usr/share"
