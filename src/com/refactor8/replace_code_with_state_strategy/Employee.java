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
		return _type.payAmount(this);
	}

	private void setType(int arg) {
		_type = EmployeeType.newType(arg);
	}

	public int getMonthlySalary() {
		return _monthlySalary;
	}


	private int getCommission() {
		return _commission;
	}

	private int getBonus() {
		return _bonus;
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
		
		abstract int payAmount(Employee emp);
	}

	static class Engineer extends EmployeeType {
		@Override
		int getTypeCode() {
			return EmployeeType.ENGINEER;
		}
		
		int payAmount(Employee emp) {
			return emp.getMonthlySalary();
		}
	}

	static class Manager extends EmployeeType {

		@Override
		int getTypeCode() {
			return EmployeeType.MANAGER;
		}
		
		int payAmount(Employee emp) {
			return emp.getMonthlySalary() + emp.getBonus();
		}
	}

	static class SalesMan extends EmployeeType {

		@Override
		int getTypeCode() {
			return EmployeeType.SALESMAN;
		}

		int payAmount(Employee emp) {
			return emp.getMonthlySalary() + emp.getCommission();
		}
	}
}
