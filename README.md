Ghidra schemas: https://github.com/NationalSecurityAgency/ghidra/tree/master/Ghidra/Framework/SoftwareModeling/data/languages

RelaxNG to xsd translator: https://relaxng.org/jclark/trang.html
Download: https://storage.googleapis.com/google-code-archive-downloads/v2/code.google.com/jing-trang/trang-20091111.zip

Usage: `java -jar .\trang.jar -I rng -O xsd .\compiler_spec.rxg .\compiler_spec.xsd`

Official 68K SLA spec:
https://github.com/NationalSecurityAgency/ghidra/blob/master/Ghidra/Processors/68000/data/languages/68000.sinc

SEGA Saturn specs(!):
https://github.com/VGKintsugi/Ghidra-SegaSaturn-Processor

~~Not sure if 24-bit words are supported for DSP56K.~~ 24-bit stuff are supported very well.

Ghidra Language Specification: https://ghidra.re/courses/languages/index.html

More 56303 goodies: https://www.ecse.rpi.edu/courses/CStudio/dsp56303/

Endianness
https://www.nxp.com/docs/en/application-note/AN2715.pdf

DSP56300 HI08 
https://www.nxp.com/docs/en/application-note/AN1808.pdf

There's both sleigh.exe and sleigh.bat.

SLEIGH / cspec / pspec etc. documentation
https://github.com/NationalSecurityAgency/ghidra/tree/master/Ghidra/Features/Decompiler/src/main/doc
https://github.com/NationalSecurityAgency/ghidra/issues/472
On Windows, `choco install -y docbook-bundle`
```
# actual SLEIGH compiler
C:\ProgramData\chocolatey\lib\ghidra\ghidra_9.1.1_PUBLIC\support\sleigh.bat -e dsp56k
# does syntax checking, but no output(?)
C:\ProgramData\chocolatey\lib\ghidra\ghidra_9.1.1_PUBLIC\Ghidra\Features\Decompiler\os\win64\sleigh.exe -e dsp56k
```
When the compiler exits successfully, it generates `dsp56k.sla`
Copy the whole `dsp56k_ghidra` folder to `Ghidra_installation/Ghidra/Processors/`
Note, the XSD attributes have to be removed when putting the files into the Ghidra installation.

## 20200624 update

- Now organized as a ghidra extension.
- Launch Ghidra from Eclipse (install GhidraDev plugin!)
- In Ghidra, run sleigh reload script in script manager. It will call sleigh compiler automatically.

```
LOAD TABLE
bank 0, addr 000000, len 000024
bank 0, addr 000060, len 000004
bank 0, addr 000024, len 00001B
bank 0, addr 000064, len 0000D3
bank 0, addr 000137, len 0001B7
bank 0, addr 0002EE, len 000001
bank 0, addr 0002EF, len 000001
bank 0, addr 0002F0, len 000001
bank 0, addr 0002F1, len 000006
bank 0, addr 0002F7, len 000001
bank 0, addr 0002F8, len 000001
bank 0, addr 0002F9, len 0000E9
bank 1, addr 000202, len 000001
bank 1, addr 000203, len 000020
bank 1, addr 000223, len 000020
bank 1, addr 000243, len 000008
bank 1, addr 000256, len 000001
bank 2, addr 000140, len 000023
bank 2, addr 000163, len 000620
bank 2, addr 0007FF, len 000001
bank 1, addr 140000, len 000080
bank 1, addr 140080, len 000080
bank 1, addr 140100, len 001000
bank 1, addr 141100, len 001000
bank 0, addr 142100, len 000191
bank 0, addr 142291, len 0005C8
bank 0, addr 142859, len 0000F0
bank 0, addr 142949, len 000200
bank 0, addr 142B49, len 000200
bank 0, addr 142D49, len 000202
bank 0, addr 142F4B, len 00046B
bank 0, addr 1433B6, len 0000F0
bank 0, addr 1434A6, len 0001EB
bank 0, addr 143691, len 00068C
bank 0, addr 143D1D, len 0000F0
bank 0, addr 143E0D, len 000143
bank 0, addr 143F50, len 000A79
bank 0, addr 1449C9, len 0000F0
bank 0, addr 144AB9, len 0001F9
bank 0, addr 144CB2, len 00024A
bank 0, addr 144EFC, len 0000F0
bank 0, addr 144FEC, len 000638
bank 0, addr 145624, len 00022B
bank 0, addr 14584F, len 000258
bank 0, addr 145AA7, len 00004E
bank 0, addr 145AF5, len 000243
bank 1, addr 146000, len 001200
bank 0, addr 147200, len 000400
bank 2, addr 147E00, len 000108
bank 0, addr 100000, len 0000A3
bank 0, addr 1000A3, len 00003A
bank 0, addr 1000DD, len 00002C
bank 0, addr 100109, len 000027
bank 0, addr 100130, len 0002AA
bank 0, addr 1003DA, len 000132
bank 0, addr 10050C, len 000120
bank 0, addr 10062C, len 000120
bank 0, addr 10074C, len 000135
bank 0, addr 100881, len 001001
bank 0, addr 101882, len 00008D
bank 0, addr 10190F, len 000040
bank 0, addr 10194F, len 000161
bank 0, addr 101AB0, len 0000F0
bank 0, addr 101BA0, len 000300
bank 0, addr 101EA0, len 00017F
bank 0, addr 10201F, len 0001D5
bank 0, addr 1021F4, len 0001D5
bank 0, addr 1023C9, len 0001FC
bank 0, addr 102600, len 000090
bank 0, addr 102700, len 000066
bank 0, addr 102780, len 000056
bank 0, addr 102800, len 000050
bank 0, addr 102880, len 00003A
bank 0, addr 1028C0, len 000034
bank 0, addr 1028F4, len 0001B5
bank 0, addr 102AA9, len 0000DE
bank 0, addr 102B87, len 000088
bank 0, addr 102C0F, len 000022
bank 0, addr 102C31, len 0000D5
bank 0, addr 102D06, len 0001E9
bank 0, addr 102EEF, len 000079
bank 0, addr 102F68, len 0000E6
bank 0, addr 10304E, len 00009E
bank 0, addr 1030EC, len 0000B7
bank 0, addr 1031A3, len 0000CF
bank 0, addr 103272, len 0000BC
bank 0, addr 10332E, len 0000C3
bank 0, addr 1033F1, len 00012C
bank 0, addr 10351D, len 000199
bank 0, addr 1036B6, len 0005C5
bank 0, addr 103C7B, len 000080
bank 0, addr 103CFB, len 000080
bank 0, addr 103D7B, len 00003F
bank 0, addr 103DBA, len 001067
bank 0, addr 104E21, len 000099
bank 0, addr 104EBA, len 000F8C
bank 0, addr 105E46, len 000099
bank 0, addr 105EDF, len 000B64
bank 0, addr 106A43, len 000099
bank 0, addr 106ADC, len 006FE3
bank 0, addr 10DABF, len 000099
bank 0, addr 10DB58, len 0017D8
bank 0, addr 10F330, len 000099
bank 0, addr 10F3C9, len 0004D9
bank 0, addr 10F8A2, len 000099
bank 0, addr 10F93B, len 000641
bank 0, addr 10FF7C, len 000099
bank 0, addr 110015, len 00157C
bank 0, addr 111591, len 000099
bank 0, addr 11162A, len 003F79
bank 0, addr 1155A3, len 000099
bank 0, addr 11563C, len 006A0E
bank 0, addr 11C04A, len 000099
bank 0, addr 11C0E3, len 006799
bank 0, addr 12287C, len 000099
bank 0, addr 122915, len 0008EC
bank 0, addr 123201, len 000099
bank 0, addr 12329A, len 004036
bank 0, addr 1272D0, len 000099
bank 0, addr 127369, len 000458
bank 0, addr 1277C1, len 000099
bank 0, addr 12785A, len 0007F7
bank 0, addr 128051, len 000099
bank 0, addr 1280EA, len 001DB1
bank 0, addr 129E9B, len 000099
bank 0, addr 129F34, len 000F66
bank 0, addr 12AE9A, len 000099
bank 0, addr 12AF33, len 001734
bank 0, addr 12C667, len 000099
bank 0, addr 12C700, len 001B55
bank 0, addr 12E255, len 000099
bank 0, addr 12E2EE, len 005573
bank 0, addr 133861, len 000099
bank 0, addr 1338FA, len 001873
bank 0, addr 13516D, len 000099
bank 0, addr FF0000, len 00005C
```
