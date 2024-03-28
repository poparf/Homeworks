#pragma once

#define QUEUE_SIZE 3

int queue[QUEUE_SIZE];
int front = 0;
int rear  = -1;

// it overwrites actual data if queue is full
void push(int val) {
	rear = (rear + 1) % QUEUE_SIZE;
	queue[rear] = val;
}


// returns 0 if it is empty
int pop() {
	int temp = queue[front];
	queue[front] = 0;
	front = (front + 1) % QUEUE_SIZE;
	return temp;
}

int getFront() {
	return queue[front];
}

int getRear() {
	return queue[rear];
}

int isFull() {
	return front == ((rear + 1) % QUEUE_SIZE);
}

int isEmpty() {
	return rear == ((front + 1) % QUEUE_SIZE);
}

void display() {
	for (int i = 0; i < QUEUE_SIZE; i++) {
		printf("%d ", queue[i]);
	}
}

void pushSafe(int val) {
    if ((front == 0 && rear == QUEUE_SIZE - 1) ||
        ((rear + 1) % QUEUE_SIZE == front))
    {
        printf("\nQueue is Full");
    }
    else if (front == -1) {
        front = rear = 0;
        queue[rear] = val;
    }
    else if (rear == QUEUE_SIZE - 1 && front != 0) {
        rear = 0;
        queue[rear] = val;
    }
    else {
        rear++;
        queue[rear] = val;
    }
}

int popSafe()
{
    if (front == -1)
    {
        printf("\nQueue is Empty");
        return -1;
    }

    int temp = queue[front];
    queue[front] = -1;
    if (front == rear)
    {
        front = -1;
        rear = -1;
    }
    else if (front == QUEUE_SIZE - 1)
        front = 0;
    else
        front++;

    return temp;
}
