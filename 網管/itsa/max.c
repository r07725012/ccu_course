#include<stdio.h>


int main()
{
	int count,i;
	float temp,max,min;

	scanf("%d",&count);
	for(count; count >0; count--)
	{		
		for(i=1; i<=10; i++)
		{		
			scanf("%f",&temp);
			if(i == 1)
			{
				max = temp; 		
				min = temp;
			}
			else if(max < temp)
			{
				max = temp;
			}
			else if(min > temp)
			{
				min = temp;		
			}

		}
		i = 1;
		printf("maximum:%.2f\n",(double)((int)(max*100)*0.01));
		printf("minimum:%.2f\n",(double)((int)(min*100)*0.01));

	}


	return 0;
}



