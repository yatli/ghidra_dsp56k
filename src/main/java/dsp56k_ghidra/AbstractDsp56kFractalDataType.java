package dsp56k_ghidra;

import ghidra.docking.settings.Settings;
import ghidra.docking.settings.SettingsDefinition;
import ghidra.program.model.data.BuiltIn;
import ghidra.program.model.data.CategoryPath;
import ghidra.program.model.data.DataOrganization;
import ghidra.program.model.data.DataType;
import ghidra.program.model.data.DataTypeManager;
import ghidra.program.model.mem.MemBuffer;

public abstract class AbstractDsp56kFractalDataType extends BuiltIn {
	private static SettingsDefinition[] SETTINGS_DEFS = {};

	public AbstractDsp56kFractalDataType(String name, DataTypeManager dataMgr) {
		super(null, name, dataMgr);
	}
	
	@Override
	public String getMnemonic(Settings settings) {
		return name;
	}
	
	@Override
	public boolean isDynamicallySized() {
		return false;
	}

	@Override
	public String getDescription() {
		return "Motorola DSP56K fractal data type";
	}

	@Override
	public Object getValue(MemBuffer buf, Settings settings, int length) {
		int len = getLength();
		byte[] bytes = new byte[len];
		long val;
		if(buf.getBytes(bytes, 0)!=len) {
			return null;
		}
		switch(len) {
		case 3:
			val = Utils.readInt3(bytes);
			return val / 8388607.0;
		case 6:
			val = Utils.readInt6(bytes);
			return val / 140737488355327.0;
		case 7:
			val = Utils.readInt7(bytes);
			return val / 140737488355327.0;
		default:
			return null;
		}
	}

	@Override
	public String getRepresentation(MemBuffer buf, Settings settings, int length) {
		Object obj = getValue(buf, settings, length);
		if (obj == null)
			return "??";
		return obj.toString();
	}
	
	@Override
	protected SettingsDefinition[] getBuiltInSettingsDefinitions() {
		return SETTINGS_DEFS;
	}

	@Override
	public String getDefaultLabelPrefix() {
		return name.toUpperCase();
	}

	@Override
	public String getCTypeDeclaration(DataOrganization dataOrganization) {
		return name;
	}


}
