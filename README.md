# The easy way

- Download the prebuilt module package
- Tick the box in the Ghidra module manager, restart.

# Setting up the dev environment

- Now organized as a ghidra extension.
- Launch Ghidra from Eclipse (install GhidraDev plugin!)
- In Ghidra, run sleigh reload script in script manager. It will call sleigh compiler automatically.

## Manually compile/update sleigh files

There's both sleigh.exe and sleigh.bat.
```
# actual SLEIGH compiler
C:\ProgramData\chocolatey\lib\ghidra\ghidra_9.1.1_PUBLIC\support\sleigh.bat -e dsp56k
# does syntax checking, but no output(?)
C:\ProgramData\chocolatey\lib\ghidra\ghidra_9.1.1_PUBLIC\Ghidra\Features\Decompiler\os\win64\sleigh.exe -e dsp56k
```
When the compiler exits successfully, it generates `dsp56k.sla`
Copy the whole `dsp56k_ghidra` folder to `Ghidra_installation/Ghidra/Processors/`

Note, this conflicts with module installation.

## Limitations and known issues

- A lot of instructions generate wrong CCR flags. The decompiler may output nonsense.
- You'll see a lot of shifting, due to the layout of the register file and the instruction semantics.
- Nested DO loop is supported, up to 3 layers. But it doesn't work everytime. "Repair flow" seems to help Ghidra to sort out the contextual state and correct the state flow.
- Not 100% instruction coverage. See https://github.com/yatli/ghidra_dsp56k/issues/1 .

## Bonus docs

Ghidra schemas: https://github.com/NationalSecurityAgency/ghidra/tree/master/Ghidra/Framework/SoftwareModeling/data/languages

RelaxNG to xsd translator: https://relaxng.org/jclark/trang.html
Download: https://storage.googleapis.com/google-code-archive-downloads/v2/code.google.com/jing-trang/trang-20091111.zip

Usage: `java -jar .\trang.jar -I rng -O xsd .\compiler_spec.rxg .\compiler_spec.xsd`

Ghidra Language Specification: https://ghidra.re/courses/languages/index.html

More 56303 goodies: https://www.ecse.rpi.edu/courses/CStudio/dsp56303/

Endianness
https://www.nxp.com/docs/en/application-note/AN2715.pdf

DSP56300 HI08 
https://www.nxp.com/docs/en/application-note/AN1808.pdf


SLEIGH / cspec / pspec etc. documentation
https://github.com/NationalSecurityAgency/ghidra/tree/master/Ghidra/Features/Decompiler/src/main/doc
https://github.com/NationalSecurityAgency/ghidra/issues/472
On Windows, `choco install -y docbook-bundle`
