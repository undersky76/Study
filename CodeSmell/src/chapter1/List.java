package chapter1;

public class List {
	private Object[] _elements = new Object[10];
	private boolean _readOnly;
	private int _size = 0;

	public void Add(Object child) {
		if (!_readOnly) {
			int newSize = _elements.length + 1;
			if (newSize > _elements.length) {
				Object[] newElements = new Object[_elements.length + 10];
				for (int i = 0; i < _size; i++) {
					newElements[i] = _elements[i];
				}

				_elements = newElements;
			}

			_elements[_size] = child;
			_size++;
		}
	}
}
