#pragma once
#include <malloc.h>

typedef struct Node {
	int data;
	struct Node* next;
}QueueNode;

typedef struct Queue {
	QueueNode* head = NULL;
	QueueNode* tail = NULL;
}Queue;

QueueNode* createNode(int data) {
	QueueNode* node = (QueueNode*)malloc(sizeof(QueueNode));
	node->data = data;
	node->next = NULL;
	return node;
}

void push(Queue* queue, int val) {
	QueueNode* node = createNode(val);
	if (queue->head == NULL) {
		// First push
		queue->head = queue->tail = node;
	}
	else {
		queue->tail->next = node;
		queue->tail = node;
	}
}

int pop(Queue* queue) {
	if (queue->head == NULL) {
		return -1;
	}
	
	int temp = queue->head->data;
	queue->head = queue->head->next;
	free(queue);
	return temp;
}

int peek(Queue* queue) {
	return queue->head->data;
}