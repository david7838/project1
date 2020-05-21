
	private final boolean allowEmpty;
	public PrimitiveNumberEditor(Class<? extends Number> numberClass, boolean allowEmpty) throws IllegalArgumentException {
		this(numberClass, null, allowEmpty);
	}
	public PrimitiveNumberEditor(Class<? extends Number> numberClass, NumberFormat numberFormat, boolean allowEmpty) throws IllegalArgumentException {
		super(numberClass, numberFormat, allowEmpty);
		this.allowEmpty = allowEmpty;
	}

