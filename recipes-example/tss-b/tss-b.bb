DESCRIPTION = "TSS B"
SECTION = "examples"
LICENSE = "CLOSED"

INHIBIT_DEFAULT_DEPS = "1"
DEPENDS += "base-files"

do_task1() {
    files=`ls -1 ${RECIPE_SYSROOT}/usr/share`
    bbwarn "do_task1 is seeing in RECIPE_SYSROOT/usr/share:\n$files"
}
addtask task1 after do_compile before do_build
do_task1[depends] += "tss-a1:do_populate_sysroot"
do_task1_simulate_delay() {
    set +e
    t=`expr $RANDOM % 10` || t=`expr $$ % 10`
    set -e
    bbwarn "sleep $t seconds to simulate extend_recipe_sysroot time"
    sleep $t
}
addtask task1_simulate_delay after do_compile before do_task1

do_task2() {
    files=`ls -1 ${RECIPE_SYSROOT}/usr/share`
    bbwarn "do_task2 is seeing in RECIPE_SYSROOT/usr/share:\n$files"
}
addtask task2 after do_compile before do_build
do_task2[depends] += "tss-a2:do_populate_sysroot"
do_task2_simulate_delay() {
    set +e
    t=`expr $RANDOM % 10` || t=`expr $$ % 10`
    set -e
    bbwarn "sleep $t seconds to simulate extend_recipe_sysroot time"
    sleep $t
}
addtask task2_simulate_delay after do_compile before do_task2

do_install() {
    files=`ls -1 ${RECIPE_SYSROOT}/usr/share 2>/dev/null`
    bbwarn "do_install is seeing in RECIPE_SYSROOT/usr/share:\n$files"
    mkdir -p ${D}/usr/share
    echo "$files" > ${D}/usr/share/from-tss-B.txt
}
do_install_simulate_delay() {
    set +e
    t=`expr $RANDOM % 10` || t=`expr $$ % 10`
    set -e
    bbwarn "sleep $t seconds to simulate extend_recipe_sysroot time"
    sleep $t
}
addtask install_simulate_delay after do_compile before do_install

FILES:${PN} += "/usr/share"

inherit nopackages
