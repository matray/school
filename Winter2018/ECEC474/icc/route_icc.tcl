set designroute s35932_route

###########################################################################
### Routing
###########################################################################

##In the layout window, click on Route -> Core Routing and Optimization

route_opt 

##Save the cel and report timing

save_mw_cel -as ${designroute}
#report_placement_utilization > reports/fifo_route_util.rpt
report_placement_utilization > reports/${designroute}_util.rpt
report_qor_snapshot > reports/${designroute}_qor_snapshot.rpt
report_qor > reports/${designroute}_qor.rpt
report_timing -max_paths 100 -delay max > reports/${designroute}.setup.rpt
report_timing -max_paths 100 -delay min > reports/${designroute}.hold.rpt
report_area > reports/${designroute}.area.rpt
report_cell > reports/${designroute}.cell.rpt
report_power > reports/${designroute}.power.rpt
report_drc_error_types > reports/${designroute}.drc.rpt

##POST ROUTE OPTIMIZATION STEPS

##Goto Layout Window, Route -> Verify Route


