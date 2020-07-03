package dsp56k_ghidra;

import ghidra.program.model.data.DataType;
import ghidra.program.model.data.DataTypeManager;

public class Dsp56kFractal24DataType extends AbstractDsp56kFractalDataType {
	
	public Dsp56kFractal24DataType() {
		this(null);
	}

	public Dsp56kFractal24DataType(DataTypeManager dataMgr) {
		super("frac24", dataMgr);
	}

	@Override
	public DataType clone(DataTypeManager dtm) {
		if (dtm == getDataTypeManager()) {
			return this;
		}
		return new Dsp56kFractal24DataType(dtm);
	}

	@Override
	public int getLength() {
		return 3;
	}

}
