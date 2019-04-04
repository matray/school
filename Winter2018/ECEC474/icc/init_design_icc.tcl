set design s35932
set cellname S35932
set designv ${design}.v
set ddc ${design}.ddc
set sdc ${design}.sdc
set frequency 100
set mw $design.mw

 set search_path "$search_path /mnt/class_data/ecec574-w2019/PDKs/SAED32nm/lib/stdcell_rvt/db_ccs
../src/ "
set target_library "saed32rvt_ss0p95v25c.db"
set link_library "* $target_library"

sh rm -rf ${mw}

start_gui
set techfile "/mnt/class_data/ecec574-w2019/PDKs/SAED32nm/tech/milkyway/saed32nm_1p9m_mw.tf"
set ref_lib "/mnt/class_data/ecec574-w2019/PDKs/SAED32nm/lib/stdcell_rvt/milkyway/saed32nm_rvt_1p9m"
#set lib_name "fifo"
set lib_name ${design}

set design_data ../dc_synth/output/${frequency}/${ddc}
#set cell_name "FIFO"
set cell_name ${cellname}
import_designs $design_data -format ddc -top $cell_name

set mw_logic0_net VSS
set mw_logic1_net VDD

set libdir "/mnt/class_data/ecec574-w2019/PDKs/SAED32nm/tech/star_rcxt"
set tlupmax "$libdir/saed32nm_1p9m_Cmax.tluplus"
set tlunom "$libdir/saed32nm_1p9m_nominal.tluplus"
set tlupmin "$libdir/saed32nm_1p9m_Cmin.tluplus"
set tech2itf "$libdir/saed32nm_tf_itf_tluplus.map"
set_tlu_plus_files -max_tluplus $tlunom -tech2itf_map $tech2itf

create_mw_lib $lib_name.mw \
		 -technology $techfile \
		 -mw_reference_library $ref_lib 
		 
open_mw_lib $lib_name.mw

read_verilog ../dc_synth/output/${frequency}/${designv}

uniquify_fp_mw_cel

link

read_sdc ../dc_synth/const/${frequency}/${sdc}

save_mw_cel -as ${design}_initial

report_operating_conditions -library ${lib_name} > reports/${design}_operating.rpt
