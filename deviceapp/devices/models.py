from django.contrib.auth.models import AbstractUser
from django.db import models
# Create your models here.


class Category(models.Model):
    name = models.CharField(max_length=50, null=False)


class Producer(models.Model):
    name = models.CharField(max_length=50, null=False)


class Location(models.Model):
    name = models.CharField(max_length=50, null=False)


class Employee(models.Model):
    name = models.CharField(max_length=50, null=False)
    CCCD = models.CharField(max_length=20, null=False, unique=True)
    phone_numbers = models.CharField(max_length=15, null=True, unique=True)


class Customer(models.Model):
    name = models.CharField(max_length=50, null=False)
    CCCD = models.CharField(max_length=20, null=False, unique=True)
    phone_numbers = models.CharField(max_length=15, null=True, unique=True)


class Device(models.Model):
    name = models.CharField(max_length=50, null=False)
    image = models.TextField()
    descriptions = models.TextField()
    bought_date = models.DateField(auto_now=True)
    producer = models.ForeignKey('Producer', on_delete=models.CASCADE)
    category = models.ForeignKey('Category', on_delete=models.CASCADE)

    class StatsChoice(models.IntegerChoices):
        GOOD = 1
        BAD = 2
        REPAIR = 3

    stats = models.IntegerField(choices=StatsChoice.choices, null=True)

    def __str__(self):
        return self.name


class Repair(models.Model):
    date = models.DateField(auto_now=True)
    cost = models.FloatField(null=False)
    device = models.ForeignKey('Device', on_delete=models.CASCADE)
    type = models.CharField(max_length=50)


class Maintenance(models.Model):
    device = models.ForeignKey('Device', on_delete=models.CASCADE)
    type = models.CharField(max_length=50)
    frequency = models.CharField(max_length=50)
    next_date = models.DateField(auto_now=True)
    reminder_sent = models.BooleanField()


class Employee_Repair(models.Model):
    employee = models.ForeignKey('Employee', on_delete=models.CASCADE)
    repair = models.ForeignKey('Repair', on_delete=models.CASCADE)


class Employee_Maintenance(models.Model):
    maintenance = models.ForeignKey('Maintenance', on_delete=models.CASCADE)
    employee = models.ForeignKey('Employee', on_delete=models.CASCADE)


class Report(models.Model):
    customer = models.ForeignKey('Customer', on_delete=models.CASCADE)
    device = models.ForeignKey('Device', on_delete=models.CASCADE)
    description = models.TextField( default="Thiết bị hư mất cmnr rồi")
    occurrence_date = models.DateField(auto_now=True)
    status = models.CharField(max_length=50)


class LocationHistory(models.Model):
    device = models.ForeignKey('Device', on_delete=models.CASCADE)
    location = models.ForeignKey('Location', on_delete=models.CASCADE)
    begin_date = models.DateField(auto_now=True)
    end_date = models.DateField()


