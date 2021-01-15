#include<stdio.h>
#include<stdlib.h>
#include<ctype.h>

#define MAX_FRAME 10

typedef struct frame * frame_ptr;
typedef struct score * score_ptr;
typedef struct final * final_ptr;

struct frame {
	int sum;
};

struct final {
	char first;
	char second;
	char third;
	int sum;
	final_ptr link;
};
final_ptr list;

struct score {
	int first;
	int second;
	int bonus;
};
frame_ptr f[MAX_FRAME];
final_ptr final[MAX_FRAME];
score_ptr s[30];

void print_list(final_ptr list) {
	int count = 1;
	while (list) {
		if (count == 10) {
			printf("%d프레임: %c | %c | %c\n\t %d\n", count, list->first, list->second, list->third, list->sum);
			list = list->link;
		}
		else {
			printf("%d프레임: %c | %c\n\t %d\n", count, list->first, list->second, list->sum);
			list = list->link;
			count++;
		}
	}
	count = 1;
}

void main() {
	int i;
	char one[100];
	char two[100];
	char ex[100];

	for (i = 0; i<MAX_FRAME - 1; i++) {

		s[i] = (score_ptr)malloc(sizeof(struct score));
		f[i] = (frame_ptr)malloc(sizeof(struct frame));
		final[i] = (final_ptr)malloc(sizeof(struct final));

		printf("첫 번째 볼링 점수를 입력하세요 : ");
		scanf("%d", &s[i]->first);
		
		if (s[i]->first > 10) {
			do {
				printf("잘못된 점수입니다. 다시 입력해주세요\n");
				printf("첫 번째 볼링 점수를 입력하세요 : ");
				scanf("%d", &s[i]->first);
			} while (s[i]->first > 10);
			
		}
		if (s[i]->first == 10) {
			s[i]->second = 0;
		}
		else {
			printf("두 번째 볼링 점수를 입력하세요 : ");
			scanf("%d", &s[i]->second);
			if (s[i]->first + s[i]->second > 10) {
				do {
					printf("잘못된 점수입니다. 다시 입력해주세요\n");
					printf("두 번째 볼링 점수를 입력하세요 : ");
					scanf("%d", &s[i]->second);
				} while (s[i]->second+s[i]->first > 10);
			}
		}

		f[i]->sum = s[i]->first + s[i]->second;
		itoa(s[i]->first, one, 10);
		itoa(s[i]->second, two, 10);
		final[i]->link = NULL;


		if (s[i]->first == 10) {					//STRIKE
			final[i]->first = 'X';
			final[i]->second = ' ';
			if (i == 0) {							//제일 처음
				final[i]->sum = NULL;
			}
			else {
				if (i > 1) {
					if (s[i - 1]->first == 10 && s[i - 2]->first == 10) {	//3연속 strike
						f[i - 2]->sum += f[i]->sum;
						f[i - 1]->sum += f[i]->sum;
						f[i-1]->sum += f[i - 2]->sum;
						final[i - 2]->sum = f[i - 2]->sum;
						final[i]->sum = NULL;
					}
					else if (s[i - 1]->first == 10) {	//2연속 strike
						f[i - 1]->sum += f[i]->sum;
						final[i]->sum = NULL;
					}
					else if (s[i - 1]->first != 10 && s[i - 1]->first + s[i - 1]->second == 10) {			//이전에 spare
						f[i - 1]->sum += s[i]->first;
						final[i - 1]->sum = f[i - 1]->sum;
						f[i]->sum += f[i - 1]->sum;
						final[i]->sum = NULL;
					}
					else {									//1번만 strike
						final[i]->sum = NULL;
						f[i]->sum += f[i - 1]->sum;
					}
					
				}
				else {
					if (s[i - 1]->first == 10) {	//2연속 strike
						f[i - 1]->sum += f[i]->sum;
						final[i]->sum = NULL;
					}
					else if (s[i - 1]->first != 10 && s[i - 1]->first + s[i - 1]->second == 10) {			//이전에 spare
						f[i - 1]->sum += s[i]->first;
						final[i - 1]->sum = f[i - 1]->sum;
						f[i]->sum += f[i - 1]->sum;
						final[i]->sum = NULL;
					}
					else {									//1번만 strike
						final[i]->sum = NULL;
						f[i]->sum += f[i - 1]->sum;
					}
					
				}
			}

		}
		else if (s[i]->first + s[i]->second == 10) {		//spare
			final[i]->first = one[0];
			final[i]->second = '/';
			if (i == 0) {									//제일 처음
				final[i]->sum = NULL;
			}
			else {
				if (i > 1) {
					if (s[i - 2]->first == 10 && s[i - 1]->first == 10) {		// 이전이전 strike
						f[i - 2]->sum += s[i]->first;
						final[i - 2]->sum = f[i - 2]->sum;
						f[i - 1]->sum += f[i - 2]->sum;
						f[i - 1]->sum += f[i]->sum;
						final[i - 1]->sum = f[i - 1]->sum;
						f[i]->sum += f[i - 1]->sum;
						final[i]->sum = NULL;
					}
					else if (s[i - 1]->first == 10) {				//이전에 strike
						f[i - 1]->sum += f[i]->sum;
						final[i - 1]->sum = f[i - 1]->sum;
						f[i]->sum += f[i - 1]->sum;
						final[i]->sum = NULL;

					}
					else if (s[i - 1]->first + s[i - 1]->second == 10) {	//이전에 spare
						f[i - 1]->sum += s[i]->first;
						final[i - 1]->sum = f[i - 1]->sum;
						f[i]->sum += f[i - 1]->sum;
						final[i]->sum = NULL;

					}
					else {									//NONE
						f[i]->sum += f[i - 1]->sum;
						final[i]->sum = NULL;
					}
				}
				else {
					if (s[i - 1]->first == 10) {				//이전에 strike
						f[i - 1]->sum += f[i]->sum;
						final[i - 1]->sum = f[i - 1]->sum;
						f[i]->sum += f[i - 1]->sum;
						final[i]->sum = NULL;

					}
					else if (s[i - 1]->first + s[i - 1]->second == 10) {	//이전에 spare
						f[i - 1]->sum += s[i]->first;
						final[i - 1]->sum = f[i - 1]->sum;
						f[i]->sum += f[i - 1]->sum;
						final[i]->sum = NULL;

					}
					else {									//NONE
						f[i]->sum += f[i - 1]->sum;
						final[i]->sum = NULL;
					}
				}
			}
		}
		else {												// NONE
			final[i]->first = one[0];
			final[i]->second = two[0];
			if (i == 0) {									//제일 처음
				final[i]->sum = f[i]->sum;
			}
			else {											//그 이후
				if (i > 1) {
					if (s[i - 1]->first == 10 && s[i - 2]->first == 10) {		//이전이전 strike
						f[i - 2]->sum += s[i]->first;
						final[i - 2]->sum = f[i - 2]->sum;
						f[i - 1]->sum += f[i - 2]->sum;
						f[i - 1]->sum += s[i]->first + s[i]->second;
						f[i]->sum += f[i - 1]->sum;
						final[i - 1]->sum = f[i - 1]->sum;
						final[i]->sum = f[i]->sum;

					}
					else if (s[i - 1]->first == 10 && s[i - 2]->first != 10) {	//이전이 strike일때
						f[i - 1]->sum += f[i]->sum;
						final[i - 1]->sum = f[i - 1]->sum;
						f[i]->sum += f[i - 1]->sum;
						final[i]->sum = f[i]->sum;
						
				}
					else if (s[i - 1]->first + s[i - 1]->second == 10) {		//이전이 spare일때
						f[i - 1]->sum += s[i]->first;
						f[i]->sum += f[i - 1]->sum;
						final[i - 1]->sum = f[i - 1]->sum;
						final[i]->sum = f[i]->sum;
					}
					else {														//아무것도 아닐때
						f[i]->sum += f[i - 1]->sum;
						final[i]->sum = f[i]->sum;
					}
				}
				else {
					if (s[i - 1]->first == 10) {							//이전이 strike일때
						f[i - 1]->sum += f[i]->sum;
						final[i - 1]->sum = f[i - 1]->sum;
						f[i]->sum += f[i - 1]->sum;
						final[i]->sum = f[i]->sum;
					}
				else if (s[i - 1]->first + s[i - 1]->second == 10) {		//이전이 spare일때
					f[i - 1]->sum += s[i]->first;
					f[i]->sum += f[i - 1]->sum;
					final[i - 1]->sum = f[i - 1]->sum;
					final[i]->sum = f[i]->sum;
				}
				else {														//아무것도 아닐때
					f[i]->sum += f[i - 1]->sum;
					final[i]->sum = f[i]->sum;
				}
				}
			}
		}
		if (i == 0) {
			list = final[i];
		}
		else
			final[i - 1]->link = final[i];

		print_list(list);
	}

	s[i] = (score_ptr)malloc(sizeof(struct score));
	f[i] = (frame_ptr)malloc(sizeof(struct frame));
	final[i] = (final_ptr)malloc(sizeof(struct final));

	printf("첫 번째 볼링 점수를 입력하세요 : ");
	scanf("%d", &s[i]->first);
	if (s[i]->first > 10) {
		do {
			printf("잘못된 점수입니다. 다시 입력해주세요\n");
			printf("첫 번째 볼링 점수를 입력하세요 : ");
			scanf("%d", &s[i]->first);
		} while (s[i]->first > 10);
	}
	
	printf("두 번째 볼링 점수를 입력하세요 : ");
	scanf("%d", &s[i]->second);
	if (s[i]->first == 10) {
		if (s[i]->second > 10) {
			do {
				printf("잘못된 점수입니다. 다시 입력해주세요\n");
				printf("두 번째 볼링 점수를 입력하세요 : ");
				scanf("%d", &s[i]->second);
			} while (s[i]->second > 10);
		}
	}
	else {
		if (s[i]->second+s[i]->first > 10) {
			do {
				printf("잘못된 점수입니다. 다시 입력해주세요\n");
				printf("두 번째 볼링 점수를 입력하세요 : ");
				scanf("%d", &s[i]->second);
			} while (s[i]->second + s[i]->first > 10);
		}
	}

	f[i]->sum = s[i]->first + s[i]->second;
	itoa(s[i]->first, one, 10);
	itoa(s[i]->second, two, 10);


	if (s[i]->first == 10) {				// 1 strike
		final[i]->first = 'X';
		printf("보너스 볼링 점수를 입력하세요 : ");
		scanf("%d", &s[i]->bonus);
		if (s[i]->bonus > 10) {
			do {
				printf("잘못된 점수입니다. 다시 입력해주세요\n");
				printf("보너스 볼링 점수를 입력하세요 : ");
				scanf("%d", &s[i]->bonus);
			} while (s[i]->bonus > 10);
		}
		itoa(s[i]->bonus, ex, 10);
		final[i]->third = ex[0];

		if (s[i - 1]->first != 10 && s[i - 1]->first + s[i - 1]->second == 10) {	//이전 spare
			f[i - 1]->sum += s[i]->first;
			final[i - 1]->sum = f[i - 1]->sum;

		}
		else if (s[i - 1]->first == 10 && s[i - 2]->first == 10) {	//3연속 strike
			f[i - 2]->sum += s[i]->first;
			f[i - 1]->sum += f[i - 2]->sum;
			f[i - 1]->sum += s[i]->first;
			final[i - 2]->sum = f[i - 2]->sum;

		}
		else if (s[i - 1]->first == 10) {	//2연속 strike
			f[i - 1]->sum += s[i]->first;

		}


		if (s[i]->second == 10) {			//2번째 strike
			final[i]->second = 'X';
			if (s[i - 1]->first == 10) {				//3연속 strike
				f[i - 1]->sum += s[i]->second;
				final[i - 1]->sum = f[i - 1]->sum;
			}

			if (s[i]->bonus == 10) {			//3 strike
				final[i]->third = 'X';
				f[i]->sum += f[i - 1]->sum + 10;
				final[i]->sum = f[i]->sum;
			}
			else {							//2 strike + none
				final[i]->third = ex[0];
				f[i]->sum += f[i - 1]->sum + s[i]->bonus;
				final[i]->sum = f[i]->sum;
			}

		}
		else {								//2번째 strike X
			if (s[i]->second + s[i]->bonus == 10) {	//1 strike + spare
				final[i]->second = two[0];
				if (s[i - 1]->first == 10) {
					f[i - 1]->sum += f[i]->sum;
					final[i - 1]->sum = f[i - 1]->sum;
					f[i]->sum += f[i - 1]->sum+s[i]->bonus;
					final[i]->sum = f[i]->sum;
				}
				else {								//9라인이 spare or none
					f[i]->sum += f[i - 1]->sum;
					final[i]->sum = f[i]->sum + s[i]->bonus;
				}
			}
			else {								//1strike+ NONE
				final[i]->second = two[0];
				final[i]->third = ex[0];
				if (s[i - 1]->first == 10) {
					f[i - 1]->sum += s[i]->second;
					final[i - 1]->sum = f[i - 1]->sum;
				}
				
				f[i]->sum += f[i - 1]->sum;
				f[i]->sum += s[i]->bonus;
				final[i]->sum = f[i]->sum;
			}
		}
		
	}
	else if (s[i]->first!=10&&s[i]->first + s[i]->second == 10) {		//spare
		final[i]->first = one[0];
		final[i]->second = '/';
		if (s[i - 1]->first == 10) {					//이전에 strike
			if (s[i - 2]->first == 10) {				// i-2 strike
				f[i - 2]->sum += s[i]->first;
				f[i - 1]->sum += f[i - 2]->sum;
				final[i - 2]->sum = f[i - 2]->sum;
				final[i - 1]->sum = f[i - 1]->sum;
				f[i]->sum += f[i - 1]->sum;
			}
			else {
				f[i - 1]->sum += f[i]->sum;				//i-1만 strike
				final[i - 1]->sum = f[i - 1]->sum;
				f[i]->sum += f[i - 1]->sum;
			}

		}
		else if (s[i-1]->first!=10&&s[i - 1]->first + s[i-1]->second == 10) {	//이전에 spare
			f[i - 1]->sum += s[i]->first;
			final[i - 1]->sum = f[i - 1]->sum;
			f[i]->sum += f[i - 1]->sum;
		}

		else {												//이전에 none
			f[i]->sum += f[i - 1]->sum;
		}
		printf("보너스 볼링 점수를 입력하세요 : ");
		scanf("%d", &s[i]->bonus);
		if (s[i]->bonus > 10) {
			do {
				printf("잘못된 점수입니다. 다시 입력해주세요\n");
				printf("보너스 볼링 점수를 입력하세요 : ");
				scanf("%d", &s[i]->bonus);
			} while (s[i]->bonus > 10);
		}
		itoa(s[i]->bonus, ex, 10);
		f[i]->sum += s[i]->bonus;
		final[i]->third = ex[0];
		if (s[i]->bonus == 10) {
			final[i]->third = 'X';
		}
		final[i]->sum = f[i]->sum;
		
	}
	else {										//none
		final[i]->first = one[0];
		final[i]->second = two[0];
		final[i]->third = NULL;

		if (s[i - 2]->first == 10 && s[i - 1]->first == 10) {		//이전 이전 strike
			f[i - 2]->sum += s[i]->first;
			final[i - 2]->sum = f[i - 2]->sum;
			f[i - 1]->sum += f[i - 2]->sum;
			f[i - 1]->sum += f[i]->sum;
			f[i]->sum += f[i - 1]->sum;
			final[i - 1]->sum = f[i - 1]->sum;
			final[i]->sum = f[i]->sum;
				
		}
		else if(s[i-2]->first!=10&&s[i-1]->first==10){			//이전 strike
			f[i - 1]->sum += f[i]->sum;
			final[i - 1]->sum = f[i - 1]->sum;
			f[i]->sum += f[i - 1]->sum;
			final[i]->sum = f[i]->sum;
		}
		else if (s[i - 1]->first != 10 && s[i - 1]->first + s[i - 1]->second == 10) {	//이전 spare
			f[i - 1]->sum += s[i]->first;
			final[i - 1]->sum = f[i - 1]->sum;
			f[i]->sum += f[i - 1]->sum;
			final[i]->sum = f[i]->sum;
		}
		else {														//이전 NONE													
				f[i]->sum += f[i - 1]->sum;
				final[i]->sum = f[i]->sum;
		}
	}
	final[i]->link = NULL;
	final[i - 1]->link = final[i];
	print_list(list);
}
