# -*- coding: utf-8 -*-
# Generated by Django 1.9.4 on 2016-03-07 03:36
from __future__ import unicode_literals

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('app', '0102_unpublished_test_teacher'),
    ]

    operations = [
        migrations.AddField(
            model_name='weixintoken',
            name='expires_in',
            field=models.PositiveIntegerField(default=0),
        ),
    ]