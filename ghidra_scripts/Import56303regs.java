//TODO write a description for this script
//@author 
//@category _NEW_
//@keybinding 
//@menupath 
//@toolbar 

import java.util.ArrayList;
import java.util.List;

import ghidra.app.script.GhidraScript;
import ghidra.program.model.util.*;
import ghidra.program.model.reloc.*;
import ghidra.program.model.data.*;
import ghidra.program.model.block.*;
import ghidra.program.model.symbol.*;
import ghidra.program.model.scalar.*;
import ghidra.program.model.mem.*;
import ghidra.program.model.listing.*;
import ghidra.program.model.lang.*;
import ghidra.program.model.pcode.*;
import ghidra.program.flatapi.FlatProgramAPI;
import ghidra.program.model.address.*;

public class Import56kregs extends GhidraScript {
	
	class Sym56k {
		public String name;
		public String comment;
		public int addr;
		public Sym56k(int a, String c, String n) {
			name = n;
			addr = a;
			comment = c;
		}
	}

    public void run() throws Exception {
		FlatProgramAPI api = new FlatProgramAPI(currentProgram);
		var spaces = api.getAddressFactory().getAllAddressSpaces();
		AddressSpace xmem = null;
		AddressSpace ymem = null;
		AddressSpace progmem = null;
		for(var i : spaces) {
			println(String.format("Address space: %s", i.getName()));
			if (i.getName().equals("xmem")) {
				println("Found xmem!");
				xmem = i;
			}
			if (i.getName().equals("ymem")) {
				println("Found ymem!");
				ymem = i;
			}
			if (i.getName().equals("progmem")) {
				println("Found progmem!");
				progmem = i;
			}
		}
		
//		var int3 = getDataTypes("int3")[0];
//		
//		for (int i=0x140000; i < 0x143675; ++i) {
//			var addr = progmem.getAddress(i, true);
//			createData(addr, int3);
//		}
		
		
		
		Sym56k[] syms = new Sym56k[] {
			new Sym56k(0xFFFFFF, "Interrupt Priority Register Core", "IPRC"),
			new Sym56k(0xFFFFFE, "Interrupt Priority Register Peripheral", "IPRP"),
			new Sym56k(0xFFFFFD, "PLL Control Register", "PCTL"),
			new Sym56k(0xFFFFFC, "OnCE GDB Register", "OGDB"),
			new Sym56k(0xFFFFFB, "Bus Control Register", "BCR"),
			new Sym56k(0xFFFFFA, "DRAM Control Register", "DCR"),
			new Sym56k(0xFFFFF9, "Address Attribute Register 0", "AAR0"),
			new Sym56k(0xFFFFF8, "Address Attribute Register 1", "AAR1"),
			new Sym56k(0xFFFFF7, "Address Attribute Register 2", "AAR2"),
			new Sym56k(0xFFFFF6, "Address Attribute Register 3", "AAR3"),
			new Sym56k(0xFFFFF5, "ID Register", "IDR"),
			new Sym56k(0xFFFFF4, "DMA Status Register", "DSTR"),
			new Sym56k(0xFFFFF3, "DMA Offset Register 0", "DOR0"),
			new Sym56k(0xFFFFF2, "DMA Offset Register 1", "DOR1"),
			new Sym56k(0xFFFFF1, "DMA Offset Register 2", "DOR2"),
			new Sym56k(0xFFFFF0, "DMA Offset Register 3", "DOR3"),
			new Sym56k(0xFFFFEF, "DMA Source Address Register", "DSR0"),
			new Sym56k(0xFFFFEE, "DMA Destination Address Register", "DDR0"),
			new Sym56k(0xFFFFED, "DMA Counter", "DCO0"),
			new Sym56k(0xFFFFEC, "DMA Control Register", "DCR0"),
			new Sym56k(0xFFFFEB, "DMA Source Address Register", "DSR1"),
			new Sym56k(0xFFFFEA, "DMA Destination Address Register", "DDR1"),
			new Sym56k(0xFFFFE9, "DMA Counter", "DCO1"),
			new Sym56k(0xFFFFE8, "DMA Control Register", "DCR1"),
			new Sym56k(0xFFFFE7, "DMA Source Address Register", "DSR2"),
			new Sym56k(0xFFFFE6, "DMA Destination Address Register", "DDR2"),
			new Sym56k(0xFFFFE5, "DMA Counter", "DCO2"),
			new Sym56k(0xFFFFE4, "DMA Control Register", "DCR2"),
			new Sym56k(0xFFFFE3, "DMA Source Address Register", "DSR3"),
			new Sym56k(0xFFFFE2, "DMA Destination Address Register", "DDR3"),
			new Sym56k(0xFFFFE1, "DMA Counter", "DCO3"),
			new Sym56k(0xFFFFE0, "DMA Control Register", "DCR3"),
			new Sym56k(0xFFFFDF, "DMA Source Address Register", "DSR4"),
			new Sym56k(0xFFFFDE, "DMA Destination Address Register", "DDR4"),
			new Sym56k(0xFFFFDD, "DMA Counter", "DCO4"),
			new Sym56k(0xFFFFDC, "DMA Control Register", "DCR4"),
			new Sym56k(0xFFFFDB, "DMA Source Address Register", "DSR5"),
			new Sym56k(0xFFFFDA, "DMA Destination Address Register", "DDR5"),
			new Sym56k(0xFFFFD9, "DMA Counter", "DCO5"),
			new Sym56k(0xFFFFD8, "DMA Control Register", "DCR5"),
			new Sym56k(0xFFFFC9, "Host Port GPIO Data Register", "HDR"),
			new Sym56k(0xFFFFC8, "Host Port GPIO Direction Register", "HDDR"),
			new Sym56k(0xFFFFC7, "Host Transmit Register", "HTX"),
			new Sym56k(0xFFFFC6, "Host Receive Register", "HRX"),
			new Sym56k(0xFFFFC5, "Host Base Address Register", "HBAR"),
			new Sym56k(0xFFFFC4, "Host Port Control Register", "HPCR"),
			new Sym56k(0xFFFFC3, "Host Status Register", "HSR"),
			new Sym56k(0xFFFFC2, "Host Control Register", "HCR"),
			new Sym56k(0xFFFFBF, "Port C Control Register", "PCRC"),
			new Sym56k(0xFFFFBE, "Port C Direction Register", "PRRC"),
			new Sym56k(0xFFFFBD, "Port C GPIO Data Register", "PDRC"),
			new Sym56k(0xFFFFBC, "ESSI 0 Transmit Data Register 0", "TX00"),
			new Sym56k(0xFFFFBB, "ESSI 0 Transmit Data Register 1", "TX01"),
			new Sym56k(0xFFFFBA, "ESSI 0 Transmit Data Register 2", "TX02"),
			new Sym56k(0xFFFFB9, "ESSI 0 Time Slot Register", "TSR0"),
			new Sym56k(0xFFFFB8, "ESSI 0 Receive Data Register", "RX0"),
			new Sym56k(0xFFFFB7, "ESSI 0 Status Register", "SSISR0"),
			new Sym56k(0xFFFFB6, "ESSI 0 Control Register B", "CRB0"),
			new Sym56k(0xFFFFB5, "ESSI 0 Control Register A", "CRA0"),
			new Sym56k(0xFFFFB4, "ESSI 0 Transmit Slot Mask Register A", "TSMA0"),
			new Sym56k(0xFFFFB3, "ESSI 0 Transmit Slot Mask Register B", "TSMB0"),
			new Sym56k(0xFFFFB2, "ESSI 0 Receive Slot Mask Register A", "RSMA0"),
			new Sym56k(0xFFFFB1, "ESSI 0 Receive Slot Mask Register B", "RSMB0"),
			new Sym56k(0xFFFFAF, "Port D Control Register", "PCRD"),
			new Sym56k(0xFFFFAE, "Port D Direction Register", "PRRD"),
			new Sym56k(0xFFFFAD, "Port D GPIO Data Register", "PDRD"),
			new Sym56k(0xFFFFAC, "ESSI 1 Transmit Data Register 0", "TX10"),
			new Sym56k(0xFFFFAB, "ESSI 1 Transmit Data Register 1", "TX11"),
			new Sym56k(0xFFFFAA, "ESSI 1 Transmit Data Register 2", "TX12"),
			new Sym56k(0xFFFFA9, "ESSI 1 Time Slot Register", "TSR1"),
			new Sym56k(0xFFFFA8, "ESSI 1 Receive Data Register", "RX1"),
			new Sym56k(0xFFFFA7, "ESSI 1 Status Register", "SSISR1"),
			new Sym56k(0xFFFFA6, "ESSI 1 Control Register B", "CRB1"),
			new Sym56k(0xFFFFA5, "ESSI 1 Control Register A", "CRA1"),
			new Sym56k(0xFFFFA4, "ESSI 1 Transmit Slot Mask Register A", "TSMA1"),
			new Sym56k(0xFFFFA3, "ESSI 1 Transmit Slot Mask Register B", "TSMB1"),
			new Sym56k(0xFFFFA2, "ESSI 1 Receive Slot Mask Register A", "RSMA1"),
			new Sym56k(0xFFFFA1, "ESSI 1 Receive Slot Mask Register B", "RSMB1"),
			new Sym56k(0xFFFF9F, "Port E Control Register", "PCRE"),
			new Sym56k(0xFFFF9E, "Port E Direction Register", "PRRE"),
			new Sym56k(0xFFFF9D, "Port E GPIO Data Register", "PDRE"),
			new Sym56k(0xFFFF9C, "SCI Control Register", "SCR"),
			new Sym56k(0xFFFF9B, "SCI Clock Control Register", "SCCR"),
			new Sym56k(0xFFFF9A, "SCI Receive Data Register—High", "SRXH"),
			new Sym56k(0xFFFF99, "SCI Receive Data Register—Middle", "SRXM"),
			new Sym56k(0xFFFF98, "SCI Receive Data Register—Low", "SRXL"),
			new Sym56k(0xFFFF97, "SCI Transmit Data Register—High", "STXH"),
			new Sym56k(0xFFFF96, "SCI Transmit Data Register—Middle", "STXM"),
			new Sym56k(0xFFFF95, "SCI Transmit Data Register—Low", "STXL"),
			new Sym56k(0xFFFF94, "SCI Transmit Address Register", "STXA"),
			new Sym56k(0xFFFF93, "SCI Status Register", "SSR"),
			new Sym56k(0xFFFF8F, "Timer 0 Control/Status Register", "TCSR0"),
			new Sym56k(0xFFFF8E, "Timer 0 Load Register", "TLR0"),
			new Sym56k(0xFFFF8D, "Timer 0 Compare Register", "TCPR0"),
			new Sym56k(0xFFFF8C, "Timer 0 Count Register", "TCR0"),
			new Sym56k(0xFFFF8B, "Timer 1 Control/Status Register", "TCSR1"),
			new Sym56k(0xFFFF8A, "Timer 1 Load Register", "TLR1"),
			new Sym56k(0xFFFF89, "Timer 1 Compare Register", "TCPR1"),
			new Sym56k(0xFFFF88, "Timer 1 Count Register", "TCR1"),
			new Sym56k(0xFFFF87, "Timer 2 Control/Status Register", "TCSR2"),
			new Sym56k(0xFFFF86, "Timer 2 Load Register", "TLR2"),
			new Sym56k(0xFFFF85, "Timer 2 Compare Register", "TCPR2"),
			new Sym56k(0xFFFF84, "Timer 2 Count Register", "TCR2"),
			new Sym56k(0xFFFF83, "Timer Prescaler Load Register", "TPLR"),
			new Sym56k(0xFFFF82, "Timer Prescaler Count Register", "TPCR"),

		};
		
		
		for (var sym: syms) {
			println(String.format("%s %d", sym.name, sym.addr));
			var addr = xmem.getAddress(sym.addr, true);
			createSymbol(addr, sym.name, true);
//			removeDataAt(addr);
//			createData(addr, int3);
			setPreComment(addr, sym.comment);
		}
		
    }

}
