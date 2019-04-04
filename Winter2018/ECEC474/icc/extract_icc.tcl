set designextracted s35932_extracted
###########################################################################
### Extraction
###########################################################################

##Go to Layout Window, Route -> Extract RC, it opens up a new window as shown below, click ok. Alternatively, you can run this script on the ICC shell:

extract_rc  -coupling_cap  -routed_nets_only  -incremental

##write parasitic to a file for delay calculations tools (e.g PrimeTime).
write_parasitics -output ./output/${designextracted}.spef -format SPEF

##Write Standard Delay Format (SDF) back-annotation file
write_sdf ./output/${designextracted}.sdf

##Write out a script in Synopsys Design Constraints format
write_sdc ./output/${designextracted}.sdc

##Write out a hierarchical Verilog file for the current design, extracted from layout
write_verilog ./output/${designextracted}.v

##Save the cel and report timing
report_timing -max_paths 20 -delay max > reports/${designextracted}.setup.rpt
report_timing -max_paths 20 -delay min > reports/${designextracted}.hold.rpt

save_mw_cel -as ${designextracted}

