package chapter1;

public class List {
	private Object[] _elements = new Object[10];
	private boolean _readOnly;
	private int _size = 0;

	public void Add(Object child) {
		if (!_readOnly) {
			int newSize = _elements.length + 1;
			if (newSize > _elements.length) {
				_elements = copyElements();
			}

			_elements[_size] = child;
			_size++;
		}
	}

	private Object[] copyElements() {
		Object[] newElements = newElements();
		for (int i = 0; i < _size; i++) {
			newElements[i] = _elements[i];
		}
		return newElements;
	}

	private static int BUPER_SIZE = 10;
	
	private Object[] newElements() {
		
		Object[] newElements = new Object[_elements.length + BUPER_SIZE];
		return newElements;
	}
}
