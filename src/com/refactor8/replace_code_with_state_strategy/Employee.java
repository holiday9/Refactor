package com.refactor8.replace_code_with_state_strategy;

public class Employee {
	private EmployeeType _type;
	private int _monthlySalary = 100;
	private int _commission = 10;
	private int _bonus = 20;

	Employee(int type) {
		setType(type);
	}

	int payAmount() {
		switch (getType()) {
		case EmployeeType.ENGINEER:
			return _monthlySalary;
		case EmployeeType.SALESMAN:
			return _monthlySalary + _commission;
		case EmployeeType.MANAGER:
			return _monthlySalary + _bonus;
		default:
			throw new RuntimeException("Incorrect Employee");
		}
	}

	private int getType() {
		return _type.getTypeCode();
	}

	private void setType(int arg) {
		_type = EmployeeType.newType(arg);
	}

	public abstract static class EmployeeType {
		static final int ENGINEER = 0;
		static final int SALESMAN = 1;
		static final int MANAGER = 2;

		abstract int getTypeCode();

		static EmployeeType newType(int code) {
			switch (code) {
			case EmployeeType.ENGINEER:
				return new Engineer();
			case EmployeeType.MANAGER:
				return new Manager();
			case EmployeeType.SALESMAN:
				return new SalesMan();

			default:
				throw new IllegalArgumentException("Incorrect Employee code");
			}
		}
	}

	static class Engineer extends EmployeeType {
		@Override
		int getTypeCode() {
			return EmployeeType.ENGINEER;
		}
	}

	static class Manager extends EmployeeType {

		@Override
		int getTypeCode() {
			return EmployeeType.MANAGER;
		}

	}

	static class SalesMan extends EmployeeType {

		@Override
		int getTypeCode() {
			return EmployeeType.SALESMAN;
		}

	}
}
