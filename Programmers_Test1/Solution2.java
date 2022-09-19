package Programmers_Test1;

import java.util.*;

class Solution2 {
	static final String[] code = new String[] {"cpp", "java", "python"};
	static final String[] field = new String[] {"backend", "frontend"};
	static final String[] level = new String[] {"junior", "senior"};
	static final String[] food = new String[] {"chicken", "pizza"};


	class Foods {
		public List<List<Person>> foodList;

		public Foods() {
			this.foodList = new ArrayList<>(List.of(new ArrayList<Person>(), new ArrayList<Person>()));
		}
	}

	class Levels {
		public List<Foods> levelList;

		public Levels(Foods foods) {
			this.levelList = new ArrayList<>();
			this.levelList.add(foods);
			this.levelList.add(foods);
		}
	}

	class Fields {
		public List<Levels> fieldList;

		public Fields(Levels levels) {
			this.fieldList = new ArrayList<>();
			this.fieldList.add(levels);
			this.fieldList.add(levels);
		}
	}

	class Codes {
		public List<Fields> codeList;

		public Codes(Fields fields) {
			this.codeList = new ArrayList<>();
			this.codeList.add(fields);
			this.codeList.add(fields);
			this.codeList.add(fields);
		}
	}

	public static void main(String[] args) {
		Solution2 s = new Solution2();
		s.solution(new String[]{"java backend junior pizza 150"}, new String[]{"java backend junior pizza 100"});
	}

	public int[] solution(String[] info, String[] query) {
		Foods foods = new Foods();
		Levels levels = new Levels(foods);
		Fields fields = new Fields(levels);
		Codes codes = new Codes(fields);

		for (int i = 0; i < info.length; i++) {
			String[] split = info[i].split(" ");
			String c = split[0];
			String f = split[1];
			String le = split[2];
			String fo = split[3];
			Person person = new Person(split[0], split[1], split[2], split[3], Integer.parseInt(split[4]));
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 2; k++) {
					for (int l = 0; l < 2; l++) {
						for (int m = 0; m < 2; m++) {
							if (c.equals(code[j]) && f.equals(field[k]) && le.equals(level[l]) && fo.equals(food[m])) {
								codes.codeList.get(j).fieldList.get(k).levelList.get(l).foodList.get(m).add(person);
							}
						}
					}
				}
			}
		}

		int[] answer = new int[query.length];
		for (int i = 0; i < query.length; i++) {
			String[] split = info[i].split(" ");
			String c = split[0];
			String f = split[1];
			String le = split[2];
			String fo = split[3];
			int score = Integer.parseInt(split[4]);
			int count = 0;
			boolean flag1 = c.equals("-");
			boolean flag2 = f.equals("-");
			boolean flag3 = le.equals("-");
			boolean flag4 = fo.equals("-");
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 2; k++) {
					for (int l = 0; l < 2; l++) {
						for (int m = 0; m < 2; m++) {
							if (!flag1 & !flag2 & flag3 & flag4) {
								if (c.equals(code[j]) && f.equals(field[k])) {
									List<Person> people1 = codes.codeList.get(j).fieldList.get(k).levelList.get(
										0).foodList.get(0);
									List<Person> people2 = codes.codeList.get(j).fieldList.get(k).levelList.get(
										0).foodList.get(1);
									List<Person> people3 = codes.codeList.get(j).fieldList.get(k).levelList.get(
										1).foodList.get(0);
									List<Person> people4 = codes.codeList.get(j).fieldList.get(k).levelList.get(
										1).foodList.get(1);
									people1.addAll(people2);
									people1.addAll(people3);
									people1.addAll(people4);
									for (Person person : people1) {
										if (person.score >= score)
											count++;
									}
								}
							} else if (!flag1 & !flag2 & flag3 & !flag4) {
								if (c.equals(code[j]) && f.equals(field[k]) && fo.equals(field[m])) {
									List<Person> people1 = codes.codeList.get(j).fieldList.get(k).levelList.get(
										0).foodList.get(m);
									List<Person> people2 = codes.codeList.get(j).fieldList.get(k).levelList.get(
										1).foodList.get(m);
									people1.addAll(people2);
									for (Person person : people1) {
										if (person.score >= score)
											count++;
									}
								}
							} else if (!flag1 & !flag2 & !flag3 & flag4) {
								if (c.equals(code[j]) && f.equals(field[k]) && le.equals(food[l])) {
									List<Person> people1 = codes.codeList.get(j).fieldList.get(k).levelList.get(
										l).foodList.get(0);
									List<Person> people2 = codes.codeList.get(j).fieldList.get(k).levelList.get(
										l).foodList.get(1);
									people1.addAll(people2);
									for (Person person : people1) {
										if (person.score >= score)
											count++;
									}
								}
							} else if (!flag1 & !flag2 & !flag3 & !flag4) {
								if (c.equals(code[j]) && f.equals(field[k]) && le.equals(food[l]) && fo.equals(
									food[m])) {
									List<Person> people1 = codes.codeList.get(j).fieldList.get(k).levelList.get(
										l).foodList.get(m);
									for (Person person : people1) {
										if (person.score >= score)
											count++;
									}
								}
							} else if (!flag1 & flag2 & flag3 & flag4) {
								if (c.equals(code[j])) {
									List<Person> people1 = codes.codeList.get(j).fieldList.get(0).levelList.get(
										0).foodList.get(0);
									List<Person> people2 = codes.codeList.get(j).fieldList.get(1).levelList.get(
										0).foodList.get(0);
									List<Person> people3 = codes.codeList.get(j).fieldList.get(0).levelList.get(
										1).foodList.get(0);
									List<Person> people4 = codes.codeList.get(j).fieldList.get(1).levelList.get(
										1).foodList.get(0);
									List<Person> people5 = codes.codeList.get(j).fieldList.get(0).levelList.get(
										0).foodList.get(1);
									List<Person> people6 = codes.codeList.get(j).fieldList.get(1).levelList.get(
										0).foodList.get(1);
									List<Person> people7 = codes.codeList.get(j).fieldList.get(0).levelList.get(
										1).foodList.get(1);
									List<Person> people8 = codes.codeList.get(j).fieldList.get(1).levelList.get(
										1).foodList.get(1);
									people1.addAll(people2);
									people1.addAll(people3);
									people1.addAll(people4);
									people1.addAll(people5);
									people1.addAll(people6);
									people1.addAll(people7);
									people1.addAll(people8);
									for (Person person : people1) {
										if (person.score >= score)
											count++;
									}
								}

							} else if (!flag1 & flag2 & flag3 & !flag4) {
								if (c.equals(code[j]) && fo.equals(food[m])) {
									List<Person> people1 = codes.codeList.get(j).fieldList.get(0).levelList.get(
										0).foodList.get(m);
									List<Person> people2 = codes.codeList.get(j).fieldList.get(1).levelList.get(
										0).foodList.get(m);
									List<Person> people3 = codes.codeList.get(j).fieldList.get(0).levelList.get(
										1).foodList.get(m);
									List<Person> people4 = codes.codeList.get(j).fieldList.get(1).levelList.get(
										1).foodList.get(m);
									people1.addAll(people2);
									people1.addAll(people3);
									people1.addAll(people4);
									for (Person person : people1) {
										if (person.score >= score)
											count++;
									}
								}
							} else if (!flag1 & flag2 & !flag3 & flag4) {
								if (c.equals(code[j]) && le.equals(food[l])) {
									List<Person> people1 = codes.codeList.get(j).fieldList.get(0).levelList.get(
										l).foodList.get(0);
									List<Person> people2 = codes.codeList.get(j).fieldList.get(1).levelList.get(
										l).foodList.get(0);
									List<Person> people3 = codes.codeList.get(j).fieldList.get(0).levelList.get(
										l).foodList.get(1);
									List<Person> people4 = codes.codeList.get(j).fieldList.get(1).levelList.get(
										l).foodList.get(1);
									people1.addAll(people2);
									people1.addAll(people3);
									people1.addAll(people4);
									for (Person person : people1) {
										if (person.score >= score)
											count++;
									}
								}

							} else if (!flag1 & flag2 & !flag3 & !flag4) {
								if (c.equals(code[j]) && le.equals(food[l]) && fo.equals(food[m])) {
									List<Person> people1 = codes.codeList.get(j).fieldList.get(0).levelList.get(
										l).foodList.get(m);
									List<Person> people2 = codes.codeList.get(j).fieldList.get(1).levelList.get(
										l).foodList.get(m);
									people1.addAll(people2);
									for (Person person : people1) {
										if (person.score >= score)
											count++;
									}
								}

							} else if (flag1 & !flag2 & flag3 & flag4) {
								if (f.equals(field[k])) {
									List<Person> people1 = codes.codeList.get(0).fieldList.get(j).levelList.get(
										0).foodList.get(0);
									people1.addAll(
										codes.codeList.get(1).fieldList.get(j).levelList.get(0).foodList.get(0));
									people1.addAll(
										codes.codeList.get(2).fieldList.get(j).levelList.get(0).foodList.get(0));
									people1.addAll(
										codes.codeList.get(0).fieldList.get(j).levelList.get(1).foodList.get(0));
									people1.addAll(
										codes.codeList.get(1).fieldList.get(j).levelList.get(1).foodList.get(0));
									people1.addAll(
										codes.codeList.get(2).fieldList.get(j).levelList.get(1).foodList.get(0));
									people1.addAll(
										codes.codeList.get(0).fieldList.get(j).levelList.get(0).foodList.get(1));
									people1.addAll(
										codes.codeList.get(1).fieldList.get(j).levelList.get(0).foodList.get(1));
									people1.addAll(
										codes.codeList.get(2).fieldList.get(j).levelList.get(0).foodList.get(1));
									people1.addAll(
										codes.codeList.get(0).fieldList.get(j).levelList.get(1).foodList.get(1));
									people1.addAll(
										codes.codeList.get(1).fieldList.get(j).levelList.get(1).foodList.get(1));
									people1.addAll(
										codes.codeList.get(2).fieldList.get(j).levelList.get(1).foodList.get(1));
									for (Person person : people1) {
										if (person.score >= score)
											count++;
									}
								}

							} else if (flag1 & !flag2 & flag3 & !flag4) {
								if (f.equals(field[k]) && fo.equals(food[m])) {
									List<Person> people1 = codes.codeList.get(0).fieldList.get(j).levelList.get(
										0).foodList.get(l);
									people1.addAll(
										codes.codeList.get(1).fieldList.get(j).levelList.get(0).foodList.get(l));
									people1.addAll(
										codes.codeList.get(2).fieldList.get(j).levelList.get(0).foodList.get(l));
									people1.addAll(
										codes.codeList.get(0).fieldList.get(j).levelList.get(1).foodList.get(l));
									people1.addAll(
										codes.codeList.get(1).fieldList.get(j).levelList.get(1).foodList.get(l));
									people1.addAll(
										codes.codeList.get(2).fieldList.get(j).levelList.get(1).foodList.get(l));
									for (Person person : people1) {
										if (person.score >= score)
											count++;
									}
								}

							} else if (flag1 & !flag2 & !flag3 & flag4) {
								if (f.equals(field[k]) && le.equals(food[l])) {
									List<Person> people1 = codes.codeList.get(0).fieldList.get(j).levelList.get(
										k).foodList.get(0);
									people1.addAll(
										codes.codeList.get(1).fieldList.get(j).levelList.get(k).foodList.get(0));
									people1.addAll(
										codes.codeList.get(2).fieldList.get(j).levelList.get(k).foodList.get(0));
									people1.addAll(
										codes.codeList.get(0).fieldList.get(j).levelList.get(k).foodList.get(1));
									people1.addAll(
										codes.codeList.get(1).fieldList.get(j).levelList.get(k).foodList.get(1));
									people1.addAll(
										codes.codeList.get(2).fieldList.get(j).levelList.get(k).foodList.get(1));
									for (Person person : people1) {
										if (person.score >= score)
											count++;
									}
								}

							} else if (flag1 & !flag2 & !flag3 & !flag4) {
								if (f.equals(field[k]) && le.equals(food[l]) && fo.equals(food[m])) {
									List<Person> people1 = codes.codeList.get(0).fieldList.get(j).levelList.get(
										k).foodList.get(l);
									people1.addAll(
										codes.codeList.get(1).fieldList.get(j).levelList.get(k).foodList.get(l));
									people1.addAll(
										codes.codeList.get(2).fieldList.get(j).levelList.get(k).foodList.get(l));
									for (Person person : people1) {
										if (person.score >= score)
											count++;
									}
								}

							} else if (flag1 & flag2 & flag3 & flag4) {
								List<Person> people1 = codes.codeList.get(0).fieldList.get(0).levelList.get(
									0).foodList.get(0);
								people1.addAll(codes.codeList.get(1).fieldList.get(0).levelList.get(0).foodList.get(0));
								people1.addAll(codes.codeList.get(2).fieldList.get(0).levelList.get(0).foodList.get(0));
								people1.addAll(codes.codeList.get(0).fieldList.get(1).levelList.get(0).foodList.get(0));
								people1.addAll(codes.codeList.get(1).fieldList.get(1).levelList.get(0).foodList.get(0));
								people1.addAll(codes.codeList.get(2).fieldList.get(1).levelList.get(0).foodList.get(0));
								people1.addAll(codes.codeList.get(0).fieldList.get(0).levelList.get(1).foodList.get(0));
								people1.addAll(codes.codeList.get(1).fieldList.get(0).levelList.get(1).foodList.get(0));
								people1.addAll(codes.codeList.get(2).fieldList.get(0).levelList.get(1).foodList.get(0));
								people1.addAll(codes.codeList.get(0).fieldList.get(1).levelList.get(1).foodList.get(0));
								people1.addAll(codes.codeList.get(1).fieldList.get(1).levelList.get(1).foodList.get(0));
								people1.addAll(codes.codeList.get(2).fieldList.get(1).levelList.get(1).foodList.get(0));
								people1.addAll(codes.codeList.get(0).fieldList.get(0).levelList.get(0).foodList.get(1));
								people1.addAll(codes.codeList.get(1).fieldList.get(0).levelList.get(0).foodList.get(1));
								people1.addAll(codes.codeList.get(2).fieldList.get(0).levelList.get(0).foodList.get(1));
								people1.addAll(codes.codeList.get(0).fieldList.get(1).levelList.get(0).foodList.get(1));
								people1.addAll(codes.codeList.get(1).fieldList.get(1).levelList.get(0).foodList.get(1));
								people1.addAll(codes.codeList.get(2).fieldList.get(1).levelList.get(0).foodList.get(1));
								people1.addAll(codes.codeList.get(0).fieldList.get(0).levelList.get(1).foodList.get(1));
								people1.addAll(codes.codeList.get(1).fieldList.get(0).levelList.get(1).foodList.get(1));
								people1.addAll(codes.codeList.get(2).fieldList.get(0).levelList.get(1).foodList.get(1));
								people1.addAll(codes.codeList.get(0).fieldList.get(1).levelList.get(1).foodList.get(1));
								people1.addAll(codes.codeList.get(1).fieldList.get(1).levelList.get(1).foodList.get(1));
								people1.addAll(codes.codeList.get(2).fieldList.get(1).levelList.get(1).foodList.get(1));
								for (Person person : people1) {
									if (person.score >= score)
										count++;

								}

							} else if (flag1 & flag2 & flag3 & !flag4) {
								if (fo.equals(food[m])) {
									List<Person> people1 = codes.codeList.get(0).fieldList.get(0).levelList.get(
										0).foodList.get(l);
									people1.addAll(
										codes.codeList.get(1).fieldList.get(0).levelList.get(0).foodList.get(l));
									people1.addAll(
										codes.codeList.get(2).fieldList.get(0).levelList.get(0).foodList.get(l));
									people1.addAll(
										codes.codeList.get(0).fieldList.get(1).levelList.get(0).foodList.get(l));
									people1.addAll(
										codes.codeList.get(1).fieldList.get(1).levelList.get(0).foodList.get(l));
									people1.addAll(
										codes.codeList.get(2).fieldList.get(1).levelList.get(0).foodList.get(l));
									people1.addAll(
										codes.codeList.get(0).fieldList.get(0).levelList.get(1).foodList.get(l));
									people1.addAll(
										codes.codeList.get(1).fieldList.get(0).levelList.get(1).foodList.get(l));
									people1.addAll(
										codes.codeList.get(2).fieldList.get(0).levelList.get(1).foodList.get(l));
									people1.addAll(
										codes.codeList.get(0).fieldList.get(1).levelList.get(1).foodList.get(l));
									people1.addAll(
										codes.codeList.get(1).fieldList.get(1).levelList.get(1).foodList.get(l));
									people1.addAll(
										codes.codeList.get(2).fieldList.get(1).levelList.get(1).foodList.get(l));
									for (Person person : people1) {
										if (person.score >= score)
											count++;
									}
								}
							} else if (flag1 & flag2 & !flag3 & flag4) {
								if (le.equals(food[l])) {
									List<Person> people1 = codes.codeList.get(0).fieldList.get(0).levelList.get(
										k).foodList.get(0);
									people1.addAll(
										codes.codeList.get(1).fieldList.get(0).levelList.get(k).foodList.get(0));
									people1.addAll(
										codes.codeList.get(2).fieldList.get(0).levelList.get(k).foodList.get(0));
									people1.addAll(
										codes.codeList.get(0).fieldList.get(1).levelList.get(k).foodList.get(0));
									people1.addAll(
										codes.codeList.get(1).fieldList.get(1).levelList.get(k).foodList.get(0));
									people1.addAll(
										codes.codeList.get(2).fieldList.get(1).levelList.get(k).foodList.get(0));
									people1.addAll(
										codes.codeList.get(0).fieldList.get(0).levelList.get(k).foodList.get(1));
									people1.addAll(
										codes.codeList.get(1).fieldList.get(0).levelList.get(k).foodList.get(1));
									people1.addAll(
										codes.codeList.get(2).fieldList.get(0).levelList.get(k).foodList.get(1));
									people1.addAll(
										codes.codeList.get(0).fieldList.get(1).levelList.get(k).foodList.get(1));
									people1.addAll(
										codes.codeList.get(1).fieldList.get(1).levelList.get(k).foodList.get(1));
									people1.addAll(
										codes.codeList.get(2).fieldList.get(1).levelList.get(k).foodList.get(1));
									for (Person person : people1) {
										if (person.score >= score)
											count++;
									}
								}
							} else if (flag1 & flag2 & !flag3 & !flag4) {
								if (le.equals(food[l]) && fo.equals(food[m])) {
									List<Person> people1 = codes.codeList.get(0).fieldList.get(0).levelList.get(
										k).foodList.get(l);
									people1.addAll(
										codes.codeList.get(1).fieldList.get(0).levelList.get(k).foodList.get(l));
									people1.addAll(
										codes.codeList.get(2).fieldList.get(0).levelList.get(k).foodList.get(l));
									people1.addAll(
										codes.codeList.get(0).fieldList.get(1).levelList.get(k).foodList.get(l));
									people1.addAll(
										codes.codeList.get(1).fieldList.get(1).levelList.get(k).foodList.get(l));
									people1.addAll(
										codes.codeList.get(2).fieldList.get(1).levelList.get(k).foodList.get(l));
									for (Person person : people1) {
										if (person.score >= score)
											count++;
									}
								}
							}
						}
					}
				}
			}
			answer[i] = count;
		}
		return answer;
	}

	class Person extends Foods {
		String code;
		String field;
		String level;
		String food;
		public int score;

		public Person(String code, String field, String level, String food, int score) {
			this.code = code;
			this.field = field;
			this.level = level;
			this.food = food;
			this.score = score;
		}
	}
}