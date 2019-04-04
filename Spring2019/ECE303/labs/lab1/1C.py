import matplotlib.pyplot as plt
import visa

def read_oscilloscope_screen(instr_name, channels):
    instr_type = instr_name[0:3]
    if not (instr_type == "USB" or instr_type == "GPI"):
        raise ValueError

    rm = visa.ResourceManager()
    instr = rm.open_resource(instr_name)
    results = []
    instr.write(":WAVEFORM:FORMAT ASCII")
    instr.write(":STOP")
    for K in range(len(channels)):
        instr.write(":WAVEFORM:SOURCE CHANNEL" + str(channels[K]))
        num_points = int(instr.query(":WAV:POIN?"))
        xincr = float(instr.query(":WAV:XINC?"))
        xref = float(instr.query(":WAV:XREF?"))
        yincr = float(instr.query(":WAV:YINC?"))
        yorigin = float(instr.query(":WAV:YOR?"))
        yref = float(instr.query(":WAV:YREF?"))

        xdat = [(N-xref)*xincr for N in range(num_points)]
        data = instr.query(":WAVEFORM:DATA?")
        temp = data[10:(-1-int(not(instr_type=="USB")))]
        temp = temp.split(',')
        if instr_type == "USB"
            ydat = [float(x) for x in temp]
        else:
            ydat = [(int(temp[i]) - yref)*yincr+yorigin for i in range(num_points)]

        results.append(xdat)
        results.append(ydat)

    return results

results = read_oscilloscope_screen("USB0:0x0957::0x1799:MY58100818::0::INSTR", [1,2])
plt.show(results[0], results[1], results[2], results[3])
plt.show()
