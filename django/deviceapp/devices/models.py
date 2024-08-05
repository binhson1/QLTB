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


class DeviceCategory(models.Model):
    name = models.CharField(max_length=50, null=False)

    class Meta:
        db_table = 'DeviceCategory'


class Location(models.Model):
    name = models.CharField(max_length=50, null=False)
    address = models.TextField()

    class Meta:
        db_table = 'Location'


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
    device_category = models.ForeignKey('DeviceCategory', on_delete=models.CASCADE)
    location_history = models.ManyToManyField("Location", through="LocationHistory")

    class StatusChoice(models.IntegerChoices):
        ACTIVE = 1
        MAINTENANCE = 2
        REPAIR = 3

    status = models.IntegerField(choices=StatusChoice.choices, null=True)

    class Meta:
        db_table = 'Device'


class ScheduleRepair(models.Model):
    date = models.DateField(auto_now=True)
    cost = models.FloatField(null=False)
    report = models.ForeignKey('Report', on_delete=models.CASCADE)
    repair_type = models.ForeignKey('RepairType', on_delete=models.CASCADE)

    class Meta:
        db_table = 'ScheduleRepair'


class ScheduleMaintenance(models.Model):
    date = models.DateField()
    frequency = models.CharField(max_length=50)
    maintenance_type = models.ForeignKey('MaintenanceType', on_delete=models.CASCADE)
    device = models.ManyToManyField("Device", through="Device_Maintenance")

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

    class JobStatusChoice(models.IntegerChoices):
        PENDING = 1
        PROCESSED = 2
        RESOLVED = 3

    status = models.IntegerField(choices=JobStatusChoice.choices, null=True)

    updated_date = models.DateTimeField(auto_now=True)

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
    device = models.ForeignKey('Device', on_delete=models.CASCADE)
    location = models.ForeignKey('Location', on_delete=models.CASCADE)
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
