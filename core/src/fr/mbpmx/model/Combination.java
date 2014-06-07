package fr.mbpmx.model;

public enum Combination {
	ONE {
		@Override
		public int countPoints(int[] dicesValues) {
			return dicesValues[0];
		}
	},
	TWO {
		@Override
		public int countPoints(int[] dicesValues) {
			return dicesValues[1] * 2;
		}
	},
	THREE {
		@Override
		public int countPoints(int[] dicesValues) {
			return dicesValues[2] * 3;
		}
	},
	FOUR {
		@Override
		public int countPoints(int[] dicesValues) {
			return dicesValues[3] * 4;
		}
	},
	FIVE {
		@Override
		public int countPoints(int[] dicesValues) {
			return dicesValues[4] * 5;
		}
	},
	SIX {
		@Override
		public int countPoints(int[] dicesValues) {
			return dicesValues[5] * 6;
		}
	},
	TWOPAIRS {
		@Override
		public int countPoints(int[] dicesValues) {
			int pairs = 0;
			if (dicesValues[1] >= 4) {
				return 25;
			}
			for (int i = 0; i < 6; i++) {
				if (dicesValues[i] >= 2) {
					pairs++;
				}
			}
			if (pairs == 2) {
				return 15;
			} else {
				return 0;
			}
		}
	},
	THREEOFAKIND {
		@Override
		public int countPoints(int[] dicesValues) {
			if (dicesValues[2] >= 2) {
				return 30;
			}
			for (int i = 0; i < 6; i++) {
				if (dicesValues[i] >= 3) {
					return 20;
				}
			}
			return 0;
		}
	},
	FULLHOUSE {
		@Override
		public int countPoints(int[] dicesValues) {
			boolean pair = false;
			boolean three = false;

			if ((dicesValues[1] == 2) && (dicesValues[2] == 3)) {
				return 35;
			}

			for (int i = 0; i < 6; i++) {
				if (dicesValues[i] == 2) {
					pair = true;
				}
				if (dicesValues[i] == 3) {
					three = true;
				}
			}
			if (pair && three) {
				return 25;
			} else {
				return 0;
			}
		}
	},
	FOUROFAKIND {
		@Override
		public int countPoints(int[] dicesValues) {
			if (dicesValues[3] >= 4) {
				return 40;
			}
			for (int i = 0; i < 6; i++) {
				if (dicesValues[i] >= 4) {
					return 30;
				}
			}
			return 0;
		}
	},
	STRAIGHT {
		@Override
		public int countPoints(int[] dicesValues) {
		    if (dicesValues[0] == 1) {
		        for (int i = 1; i < 5; i++) {
		            if (dicesValues[i] != 1) {
		                return 0;
		            }
		        }
		    } else if (dicesValues[0] == 0) {
		        for (int i = 1; i < 6; i++) {
                    if (dicesValues[i] != 1) {
                        return 0;
                    }
		        }
		    } else {
		        return 0;
		    }
			return 40;
		}
	},
	YAMS {
		@Override
		public int countPoints(int[] dicesValues) {
			if (dicesValues[4] == 5) {
				return 60;
			}
			for (int i = 0; i < 6; i++) {
				if (dicesValues[i] == 5) {
					return 50;
				}
			}
			return 0;
		}
	},
	PLUS {
		@Override
		public int countPoints(int[] dicesValues) {
			int sum = 0;
			for (int i = 0; i < 6; i++) {
				sum += dicesValues[i] * (i + 1);
			}
			return sum;
		}
	},
	MINUS {
		@Override
		public int countPoints(int[] dicesValues) {
			int sum = 0;
			for (int i = 0; i < 6; i++) {
				sum += dicesValues[i] * (i + 1);
			}
			return sum;
		}
	},
	CHANCE {
		@Override
		public int countPoints(int[] dicesValues) {
			int sum = 0;
			for (int i = 0; i < 6; i++) {
				sum += dicesValues[i] * (i + 1);
			}
			return sum;
		}
	};

	public abstract int countPoints(int[] dicesValues);
}
