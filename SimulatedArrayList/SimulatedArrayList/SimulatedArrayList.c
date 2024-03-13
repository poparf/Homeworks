#include <stdio.h>
#include <stdlib.h> 
// Popa Florian grupa 1072

typedef struct Node
{
    unsigned int index;
    int* data;
    unsigned int noElements;
    struct Node* next;
} Node;

Node* head = NULL;
int size = 0;

Node* createNode(int* val, unsigned int noElem) {
    Node* newNode = (Node*)malloc(sizeof(Node));
    newNode->data = (int*)malloc(noElem * sizeof(int));
    for (unsigned int i = 0; i < noElem; i++) {
        newNode->data[i] = val[i];
    }
    newNode->noElements = noElem;
    size += 1;
    newNode->index = size;
    newNode->next = NULL;
    return newNode;
}

int* front() {
    if (head != NULL)
        return head->data;
    else
        return NULL;
}

int* back() {
    Node* temp = head;
    if (temp == NULL) return NULL;
    while (temp->next != NULL) {
        temp = temp->next;
    }
    return temp->data;
}

void push_back(int* val, unsigned int noElem) {
    if (head == NULL) {
        head = createNode(val, noElem);
    }
    else {
        Node* temp = head;
        while (temp->next != NULL) {
            temp = temp->next;
        }
        temp->next = createNode(val, noElem);
    }
}

void push_front(int* val, unsigned int noElem) {
    Node* newNode = createNode(val, noElem);
    newNode->next = head;
    head = newNode;
}

void pop_back() {
    if (head == NULL) return;
    if (head->next == NULL) {
        free(head->data);
        free(head);
        head = NULL;
        size = 0;
        return;
    }
    Node* temp = head;
    while (temp->next->next != NULL) {
        temp = temp->next;
    }
    free(temp->next->data);
    free(temp->next);
    temp->next = NULL;
    size--;
}

void pop_front() {
    if (head == NULL) return;
    Node* temp = head;
    head = head->next;
    free(temp->data);
    free(temp);
    size--;
}

void removeAt(int index) {
    if (index <= 0 || index > size) return;
    if (index == 1) {
        pop_front();
        return;
    }
    if (index == size) {
        pop_back();
        return;
    }
    Node* temp = head;
    for (int i = 1; i < index - 1; i++) {
        temp = temp->next;
    }
    Node* toRemove = temp->next;
    temp->next = toRemove->next;
    free(toRemove->data);
    free(toRemove);
    size--;
}

void insertAt(int index, int* val, unsigned int noElem) {
    if (index <= 0 || index > size + 1) return;
    if (index == 1) {
        push_front(val, noElem);
        return;
    }
    if (index == size + 1) {
        push_back(val, noElem);
        return;
    }
    Node* newNode = createNode(val, noElem);
    Node* temp = head;
    for (int i = 1; i < index - 1; i++) {
        temp = temp->next;
    }
    newNode->next = temp->next;
    temp->next = newNode;
}

int* getAt(int index) {
    if (index <= 0 || index > size) return NULL;
    Node* temp = head;
    for (int i = 1; i < index; i++) {
        temp = temp->next;
    }
    return temp->data;
}

void freeList() {
    while (head != NULL) {
        Node* temp = head;
        head = head->next;
        free(temp->data);
        free(temp);
    }
    size = 0;
}

int main() {
    int* values = (int*)malloc(sizeof(int) * 3);
    values[0] = 1;
    values[1] = 2;
    values[2] = 3;
    push_front(values, 3);
    push_front(values, 3);
    push_front(values, 3);
    printf("%d", getAt(1)[0]);
    return 0;
}
