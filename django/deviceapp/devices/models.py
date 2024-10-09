from django.contrib.auth.models import AbstractUser
from django.db import models


class User(AbstractUser):
    avatar = models.TextField()
    user_role = models.CharField(max_length=100)
    email = models.CharField(max_length=50)
    phone = models.CharField(max_length=50)

    class Meta:
        db_table = 'User'


class Manufacturer(models.Model):
    name = models.CharField(max_length=50, null=False)

    class Meta:
        db_table = 'Manufacturer'


class Category(models.Model):
    name = models.CharField(max_length=50, null=False)

    class Meta:
        db_table = 'Category'


class Facility(models.Model):
    name = models.CharField(max_length=50, null=False, unique=True)
    address = models.CharField(max_length=500, null=False)

    class Meta:
        db_table = 'Facility'


class Room(models.Model):
    number = models.CharField(max_length=50, null=False, unique=True)
    facility = models.ForeignKey("Facility", on_delete=models.CASCADE)


    class Meta:
        db_table = 'Room'


class Employee(models.Model):
    name = models.CharField(max_length=50, null=False)
    CCCD = models.CharField(max_length=20, null=False, unique=True)
    phone = models.CharField(max_length=15, null=True, unique=True)

    class Meta:
        db_table = 'Employee'


class Device(models.Model):
    name = models.CharField(max_length=50, null=False)
    image = models.TextField()
    descriptions = models.TextField()
    bought_date = models.DateField()
    manufacturer = models.ForeignKey('Manufacturer', on_delete=models.CASCADE)
    category = models.ForeignKey('Category', on_delete=models.CASCADE)

    status = models.CharField(max_length=50)

    class Meta:
        db_table = 'Device'


class ScheduleRepair(models.Model):
    date = models.DateField(auto_now=True)
    cost = models.FloatField(null=False)
    report = models.ForeignKey('Report', on_delete=models.CASCADE)
    repair_type = models.ForeignKey('RepairType', on_delete=models.CASCADE)
    name = models.TextField()

    class Meta:
        db_table = 'ScheduleRepair'


class ScheduleMaintenance(models.Model):
    last_maintenance_date = models.DateField()
    next_maintenance_date = models.DateField()
    interval_month = models.IntegerField()
    maintenance_type = models.ForeignKey('MaintenanceType', on_delete=models.CASCADE)
    device = models.ManyToManyField("Device", through="Device_Maintenance")
    name = models.TextField()

    class Meta:
        db_table = 'ScheduleMaintenance'


class Device_Maintenance(models.Model):
    device = models.ForeignKey("Device", on_delete=models.CASCADE)
    schedule_maintenance = models.ForeignKey("ScheduleMaintenance", on_delete=models.CASCADE)

    class Meta:
        db_table = 'Device_Maintenance'


class Job(models.Model):
    employee = models.ForeignKey('Employee', on_delete=models.CASCADE)
    maintenance = models.ForeignKey('ScheduleMaintenance', on_delete=models.CASCADE, blank=True, null=True)
    repair = models.ForeignKey('ScheduleRepair', on_delete=models.CASCADE, blank=True, null=True)
    start_date = models.DateTimeField()
    end_date = models.DateTimeField(null=True)
    status = models.CharField(max_length=50)
    updated_date = models.DateTimeField(auto_now=True)
    name = models.TextField()

    class Meta:
        db_table = 'Job'


class Report(models.Model):
    user = models.ForeignKey('User', on_delete=models.CASCADE)
    device = models.ForeignKey('Device', on_delete=models.CASCADE)
    description = models.TextField()
    occurrence_date = models.DateTimeField(auto_now=True)
    severity = models.CharField(max_length=50)
    status = models.CharField(max_length=50)

    class Meta:
        db_table = 'Report'


class LocationHistory(models.Model):
    room = models.ForeignKey('Room', on_delete=models.CASCADE)
    device = models.ForeignKey('Device', on_delete=models.CASCADE)
    begin_date = models.DateField(auto_now=True)
    end_date = models.DateField(null=True, blank=True)
    active = models.BooleanField(default=True)

    class Meta:
        db_table = 'LocationHistory'


class MaintenanceType(models.Model):
    name = models.TextField()

    class Meta:
        db_table = 'MaintenanceType'


class RepairType(models.Model):
    name = models.TextField()

    class Meta:
        db_table = 'RepairType'


class ReportRepairHistory(models.Model):
    title = models.TextField()
    content = models.TextField()
    report = models.ForeignKey('Report', on_delete=models.CASCADE, blank=True, null=True)
    category = models.ForeignKey('Category', on_delete=models.CASCADE, blank=True, null=True)


class Post(models.Model):
    title = models.TextField()
    content = models.TextField()
    create_date = models.DateField(auto_now=True)
    user = models.ForeignKey('User', on_delete=models.CASCADE)

    class Meta:
        db_table = 'Post'


class ReplacementPart(models.Model):
    name = models.CharField(max_length=100, null=False)
    manufacturer = models.ForeignKey('Manufacturer', on_delete=models.CASCADE)
    device = models.ForeignKey('Device', on_delete=models.CASCADE)
    quantity = models.IntegerField(default=0)
    replacement_date = models.DateField(auto_now=True)

    class Meta:
        db_table = 'ReplacementPart'


class Transaction(models.Model):
    TRANSACTION_TYPES = [
        ('buy', 'Buy'),
        ('sell', 'Sell'),
        ('borrow', 'Borrow'),
        ('return', 'Return'),
    ]

    device = models.ForeignKey('Device', on_delete=models.CASCADE)
    user = models.ForeignKey('User', on_delete=models.CASCADE)
    transaction_type = models.CharField(max_length=10, choices=TRANSACTION_TYPES)
    transaction_date = models.DateField(auto_now=True)
    notes = models.TextField(null=True, blank=True)

    class Meta:
        db_table = 'Transaction'


class DeviceLifecycle(models.Model):
    device = models.ForeignKey('Device', on_delete=models.CASCADE)
    lifecycle_stage = models.CharField(max_length=50)
    description = models.TextField(null=True, blank=True)
    start_date = models.DateField(auto_now_add=True)
    end_date = models.DateField(null=True, blank=True)

    class Meta:
        db_table = 'DeviceLifecycle'


class DeviceUsage(models.Model):
    device = models.ForeignKey('Device', on_delete=models.CASCADE)
    user = models.ForeignKey('User', on_delete=models.CASCADE)
    usage_start = models.DateTimeField()
    usage_end = models.DateTimeField(null=True, blank=True)
    total_usage_time = models.DurationField(null=True, blank=True)

    class Meta:
        db_table = 'DeviceUsage'
