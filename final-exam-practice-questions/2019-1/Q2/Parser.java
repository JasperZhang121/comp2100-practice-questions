/**
 * IMPORTANT: This class is incomplete. Please look for "TODO" comments.
 * 
 * @author huy.pham
 */
public class Parser {
	private Tokenizer _tokenizer;
	private Screen _screen;

	public Parser(Tokenizer tokenizer, Screen screen) {
		_tokenizer = tokenizer;
		_screen = screen;
	}

    /**
     * This should parse all the tokens, turn the pointer and mark its visited positions for
     * every move.
     *
     * If there is no more token, this should return the current screen
     *
     * @return a screen object containing pointer's trace information.
     * @throws Exception
     */
    public Screen parse() throws OutOfScreenException {
        // TODO: Add your implementation here.
        // hints: Check {@link Screen} and {@link Pointer} classes to see there is any methods/functions you can take advantage of.
		// get the position of pointer
		var pos = _screen.pointer.position;
		while (_tokenizer.hasNext()){
			var temp = _tokenizer.takeNext();
			// if token is penUp
			if (temp.type== Token.Type.PENUP){
				_screen.pointer.isPenDown=false;
			}
			// if token is penDown
			if (temp.type== Token.Type.PENDOWN){
				_screen.pointer.isPenDown=true;
				_screen.markVisistedPos(_screen.pointer.position);
			}
			// if token is left
			if (temp.type== Token.Type.LEFT){
				_screen.pointer.turnLeft();
			}
			// if token is right
			if (temp.type == Token.Type.RIGHT){
				_screen.pointer.turnRight();
			}
			// if token is forward (consider directions)
			if (temp.type == Token.Type.FORWARD){
				var steps = temp.value;
				if (_screen.pointer.isPenDown) _screen.markVisistedPos(_screen.pointer.position);
				// if point upward
				if (_screen.pointer.direction==Direction.Upward){
					// mark visited
					if (_screen.pointer.isPenDown){for (int i = 0; i < steps+1; i++) {
						_screen.markVisistedPos(new Position(pos.x-i,pos.y));
					}}
					// reset pointer position
					_screen.pointer.position.x-=steps;
				}
				// if point downward
				if (_screen.pointer.direction==Direction.Downward){
					if (_screen.pointer.isPenDown){
						for (int i = 0; i < steps+1; i++) {
							_screen.markVisistedPos(new Position(pos.x+i,pos.y));
						}
					}
					// reset pointer position
					_screen.pointer.position.x+=steps;
				}
				if (_screen.pointer.direction == Direction.Left){
					if (_screen.pointer.isPenDown){
						for (int i = 0; i < steps+1; i++) {
							_screen.markVisistedPos(new Position(pos.x,pos.y-i));
						}
					}
					// reset pointer position
					_screen.pointer.position.y-=steps;
				}
				if (_screen.pointer.direction == Direction.Right){
					if (_screen.pointer.isPenDown){
						for (int i = 0; i < steps+1; i++) {
							_screen.markVisistedPos(new Position(pos.x,pos.y+i));
						}
					}
					// reset pointer position
					_screen.pointer.position.y+=steps;
				}
			}
			// token is back (copy part of above)
			if (temp.type== Token.Type.BACK) {
				var steps = temp.value;
				if (_screen.pointer.isPenDown) _screen.markVisistedPos(_screen.pointer.position);
				// if point downward
				if (_screen.pointer.direction == Direction.Upward) {
					// mark visited
					if (_screen.pointer.isPenDown){
						for (int i = 0; i < steps+1; i++) {
							_screen.markVisistedPos(new Position(pos.x+i, pos.y));
						}
					}
					// reset pointer position
					_screen.pointer.position.x += steps;
				}
				// if point downward
				if (_screen.pointer.direction == Direction.Downward) {
					if (_screen.pointer.isPenDown){
						for (int i = 0; i < steps+1; i++) {
							_screen.markVisistedPos(new Position(pos.x-i, pos.y));
						}
					}
					// reset pointer position
					_screen.pointer.position.x -= steps;
				}
				if (_screen.pointer.direction == Direction.Left) {

					if (_screen.pointer.isPenDown){
						for (int i = 0; i < steps+1; i++) {
							_screen.markVisistedPos(new Position(pos.x, pos.y-i));
						}
					}
					// reset pointer position
					_screen.pointer.position.y -= steps;
				}
				if (_screen.pointer.direction == Direction.Right) {
					if (_screen.pointer.isPenDown){
						for (int i = 0; i < steps+1; i++) {
							_screen.markVisistedPos(new Position(pos.x, pos.y+i));
						}
					}
					// reset pointer position
					_screen.pointer.position.y += steps;
				}
			}
		}
		return _screen;
	}
}
