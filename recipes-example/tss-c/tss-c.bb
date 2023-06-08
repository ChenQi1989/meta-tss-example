DESCRIPTION = "TSS C"
SECTION = "examples"
LICENSE = "CLOSED"

INHIBIT_DEFAULT_DEPS = "1"
DEPENDS += "base-files"

do_task_c1() {
    files=`ls -1 ${RECIPE_SYSROOT}/usr/share`
    bbwarn "do_task_c1 is seeing in RECIPE_SYSROOT/usr/share:\n$files"
}
addtask task_c1 after do_configure before do_build
do_task_c1[depends] += "tss-a1:do_populate_sysroot tss-a2:do_populate_sysroot"

do_task_c2() {
    files=`ls -1 ${RECIPE_SYSROOT}/usr/share`
    bbwarn "do_task_c2 is seeing in RECIPE_SYSROOT/usr/share:\n$files"
}
addtask task_c2 after do_configure before do_build

#
# In case of TSS, switching the deps below changes output of do_task_c2.
# With no TSS, the output remains the same.
#

do_task_c2[depends] += "tss-a1:do_populate_sysroot tss-a2:do_populate_sysroot"
#do_task_c2[depends] += "tss-a1:do_populate_sysroot"

inherit nopackages
