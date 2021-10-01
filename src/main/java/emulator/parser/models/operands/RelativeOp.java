package emulator.parser.models.operands;

import emulator.cpu.AddressingMode;

public class RelativeOp extends Operand{

    public AddressingMode type;
    
    public RelativeOp(String value, int position, int lineNumber) {
        super(value, position, lineNumber);
        this.type = AddressingMode.RELATIVE;
        this.size = 16;    
    }
}
