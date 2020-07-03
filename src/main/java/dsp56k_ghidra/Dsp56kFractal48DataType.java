package dsp56k_ghidra;

import ghidra.program.model.data.DataType;
import ghidra.program.model.data.DataTypeManager;

public class Dsp56kFractal48DataType extends AbstractDsp56kFractalDataType {
	
	public Dsp56kFractal48DataType() {
		this(null);
	}

	public Dsp56kFractal48DataType(DataTypeManager dataMgr) {
		super("frac48", dataMgr);
	}

	@Override
	public DataType clone(DataTypeManager dtm) {
		if (dtm == getDataTypeManager()) {
			return this;
		}
		return new Dsp56kFractal48DataType(dtm);
	}

	@Override
	public int getLength() {
		return 6;
	}

}
