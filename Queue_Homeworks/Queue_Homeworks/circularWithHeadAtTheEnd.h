#pragma once
#include <malloc.h>

typedef struct Node {
	int data;
	struct Node* next;
}QueueNode;

typedef struct Queue {
	QueueNode* head = NULL;
}Queue;

QueueNode* createNode(int data) {
	QueueNode* node = (QueueNode*)malloc(sizeof(QueueNode));
	node->data = data;
	node->next = NULL;
	return node;
}

void push(Queue* queue, int data) {
	QueueNode* node = createNode(data);

	if (queue->head == NULL) {
		queue->head = node;
		node->next = node;
	}
	else {
		node->next = queue->head->next;
		queue->head = node;
	}
}

int pop(Queue* queue) {
	int temp = queue->head->next->data;
	QueueNode* tempNode = queue->head->next;
	queue->head->next = tempNode->next;
	free(tempNode);
	return temp;
}

int peek(Queue* queue) {
	return queue->head->next->data;
}