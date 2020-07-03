function sleigh()
{
  C:\Tools\ghidra_9.1.2_PUBLIC\support\sleigh.bat -e dsp56k
}

function check()
{
  C:\Tools\ghidra_9.1.2_PUBLIC\Ghidra\Features\Decompiler\os\win64\sleigh.exe -e dsp56k
}

function install()
{
  Copy-Item .\dsp56k.sla C:\Tools\ghidra_9.1.2_PUBLIC\Ghidra\Processors\dsp56k\data\languages\dsp56k.sla -Force
  Copy-Item .\dsp56k.slaspec C:\Tools\ghidra_9.1.2_PUBLIC\Ghidra\Processors\dsp56k\data\languages\dsp56k.slaspec -Force
}
