package emulator.parser.models.operands;
import emulator.cpu.AddressingMode;
import emulator.parser.models.errors.InvalidTokenException;
import util.Conversions;

/**
 * Instance of ImmediateOp will have size as type int
 */
public class ImmediateOp extends Operand{

    public AddressingMode type;
    public int size;
    public int value;
    
    public ImmediateOp(String value, int position, int lineNumber) throws Exception, InvalidTokenException{
        super(value, position, lineNumber);
        this.type = AddressingMode.IMMEDIATE;

        int[] toNum = Conversions.toNumber(value);
        this.value = toNum[0];
        this.size = toNum[1];
    }
    
}
