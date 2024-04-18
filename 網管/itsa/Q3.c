#include<stdio.h>
#include<string.h>
#include<stdlib.h>
int main(){	

	int cnt=0,i=0;
	double num=0,tmp=0;
	int len=0;
	char input[20]={0};
	char *ptr;
	scanf("%d", &cnt);
	//printf("%d",cnt);
	while(cnt!=0){
		
		scanf("%s",input);
		num=atof(input);
		ptr=input;
		if((ptr=strstr(input,","))!=NULL){
			//printf("%s",ptr);
			ptr++;
			len=atoi(ptr);
		}
		//printf("%f %d",num,i);	
		for(i=1;i<=len;i++)
		num=num+(i*2.71828);
		
		printf("%.4f\n",num);
		cnt--;
	}	
	return 0;
}
