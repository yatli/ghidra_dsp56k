//TODO write a description for this script
//@author 
//@category _NEW_
//@keybinding 
//@menupath 
//@toolbar 

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
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

public class DumpDspData extends GhidraScript {
	public DataType int3; 

    public void run() throws Exception {
		var symiter = currentProgram.getSymbolTable().getAllSymbols(false);
		var syms = new ArrayList<Symbol>();
		while(symiter.hasNext()) {
			syms.add(symiter.next());
		}
		int3 = getDataTypes("int3")[0];
		Symbol prev_ = null, prev = null;
		for(var cur: syms) {
			prev = prev_;
			prev_ = cur;
			
			dump(prev, cur);
		}
	}

	private void dump(Symbol prev, Symbol cur) throws Exception {
		if(prev==null) return;
		if(prev.getSymbolType() != SymbolType.LABEL) return;
		var addr1 = prev.getAddress();
		var addr2 = cur.getAddress();
		var sp1 = addr1.getAddressSpace();
		var sp2 = addr2.getAddressSpace();
		if (sp1 != sp2) return;
		var data = getDataAt(addr1);
		if(data==null || data.getDataType()!=int3) return;
		var start = addr1.getOffset()/3;
		var end = addr2.getOffset()/3;
		if(start >= 0xff0000) return;
		
		println(String.format("Dumping segment %s @ %X-%X", prev.getName(), start, end));
		var txt_name=String.format("%s-%s-%X-%X.txt", sp1.getName(), prev.getName(), start, end);
		var dat_name=String.format("%s-%s-%X-%X.bin", sp1.getName(), prev.getName(), start, end);
		
		var txt_file=new PrintWriter(txt_name, "UTF-8");
		var dat_file=new DataOutputStream(new FileOutputStream(dat_name));
		for(long i=start; i<end; ++i) {
			data = getDataAt(addr1);
			if (data==null) break;
			var value = data.getBigInteger(0, 3, true).intValue() / 256;
			txt_file.println(value);
			dat_file.writeShort(value);
			addr1 = addr1.add(3);
		}
		txt_file.close();
		dat_file.close();
	}
}
