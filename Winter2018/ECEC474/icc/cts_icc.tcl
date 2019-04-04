set design s35932

###########################################################################
### Clock Tree Synthesis
###########################################################################

##In the Layout window, click on "Clock ", you will see various options, you can set any of the options to run CTS. If you click on Clock ' Core CTS and Optimization

##Save the Cell and report timing

save_mw_cel -as ${design}_cts
report_placement_utilization > reports/${design}_cts_util.rpt
report_qor_snapshot > reports/${design}_cts_qor_snapshot.rpt
report_qor > reports/${design}_cts_qor.rpt
report_timing -max_paths 20 -delay max > reports/${design}_cts.setup.rpt
report_timing -max_paths 20 -delay min > reports/${design}_cts.hold.rpt
report_clock_tree -summary > reports/${design}_clocktree.rpt
#report_operating_conditions -library "saed32rvt_ss0p95v25c.db" > reports/${design}_operating.rpt
